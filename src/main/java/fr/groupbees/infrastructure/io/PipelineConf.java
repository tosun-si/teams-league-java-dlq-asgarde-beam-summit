package fr.groupbees.infrastructure.io;

import lombok.Builder;
import lombok.Getter;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;

import java.io.Serializable;

@Builder
@Getter
public class PipelineConf implements Serializable {

    private final String inputJsonFile;
    private final String teamLeagueDataset;
    private final String teamStatsTable;
}
