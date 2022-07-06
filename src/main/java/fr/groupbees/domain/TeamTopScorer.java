package fr.groupbees.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@ToString
public class TeamTopScorer implements Serializable {

    private String scorerFirstName;
    private String scorerLastName;
    private int scoreNumber;
    private int matchNumber;
}
