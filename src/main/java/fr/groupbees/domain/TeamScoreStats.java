package fr.groupbees.domain;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class TeamScoreStats implements Serializable {

    private String topScorerFirstName;
    private String topScorerLastName;
    private int topScorerGoalsNumber;
    private int topScorerGamesNumber;
    private int totalScoreNumber;
}
