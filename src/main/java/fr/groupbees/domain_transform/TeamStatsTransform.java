package fr.groupbees.domain_transform;

import fr.groupbees.asgarde.CollectionComposer;
import fr.groupbees.asgarde.Failure;
import fr.groupbees.domain.TeamStats;
import fr.groupbees.domain.TeamStatsRaw;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.WithFailures.Result;
import org.apache.beam.sdk.values.PCollection;

import static org.apache.beam.sdk.values.TypeDescriptor.of;

public class TeamStatsTransform extends PTransform<PCollection<TeamStatsRaw>, Result<PCollection<TeamStats>, Failure>> {

    @Override
    public Result<PCollection<TeamStats>, Failure> expand(PCollection<TeamStatsRaw> input) {
        return CollectionComposer.of(input)
                .apply("Validate fields", MapElements.into(of(TeamStatsRaw.class)).via(TeamStatsRaw::validateFields))
                .apply("Compute team stats", MapElements.into(of(TeamStats.class)).via(TeamStats::computeTeamStats))
                .apply("Add team slogan", MapElements.into(of(TeamStats.class)).via(TeamStats::addSloganToStats))
                .getResult();
    }
}
