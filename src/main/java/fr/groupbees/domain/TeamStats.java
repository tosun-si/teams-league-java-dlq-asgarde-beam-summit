package fr.groupbees.domain;

import com.google.common.collect.ImmutableMap;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class TeamStats implements Serializable {

    private static final Map<String, String> TEAM_SLOGANS = ImmutableMap.of(
            "PSG", "Paris est magique",
            "Real", "Hala Madrid"
    );

    private String teamName;
    private int teamScore;
    private String teamSlogan;
    private TeamScoreStats scoreStats;

    public static TeamStats computeTeamStats(final TeamStatsRaw teamStatsRaw) {
        final List<TeamScorerRaw> teamScorers = teamStatsRaw.getScorers();

        final TeamScorerRaw topScorer = teamScorers.stream()
                .max(Comparator.comparing(TeamScorerRaw::getGoalsNumber))
                .orElseThrow(NoSuchElementException::new);

        final int totalScoreTeam = teamScorers.stream()
                .mapToInt(TeamScorerRaw::getGoalsNumber)
                .sum();

        final TeamScoreStats scoreStats = TeamScoreStats.builder()
                .topScorerFirstName(topScorer.getScorerFirstName())
                .topScorerLastName(topScorer.getScorerLastName())
                .topScorerGoalsNumber(topScorer.getGoalsNumber())
                .topScorerGamesNumber(topScorer.getGamesNumber())
                .totalScoreNumber(totalScoreTeam)
                .build();

        return TeamStats.builder()
                .teamName(teamStatsRaw.getTeamName())
                .teamScore(teamStatsRaw.getTeamScore())
                .scoreStats(scoreStats)
                .build();
    }

    public TeamStats addSloganToStats() {
        final String slogan = Optional
                .ofNullable(TEAM_SLOGANS.get(teamName))
                .orElseThrow(() -> new IllegalArgumentException("No slogan for team : " + teamName));

        return this
                .toBuilder()
                .teamSlogan(slogan)
                .build();
    }
}
