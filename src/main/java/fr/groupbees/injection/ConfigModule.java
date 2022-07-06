package fr.groupbees.injection;

import dagger.Module;
import dagger.Provides;
import fr.groupbees.application.TeamLeagueOptions;
import fr.groupbees.domain.FailureConf;

@Module
class ConfigModule {

    @Provides
    static FailureConf provideFailureConf(TeamLeagueOptions options) {
        return FailureConf
                .builder()
                .featureName(options.getFailureFeatureName())
                .jobName(options.getJobType())
                .outputDataset(options.getFailureOutputDataset())
                .outputTable(options.getFailureOutputTable())
                .build();
    }
}
