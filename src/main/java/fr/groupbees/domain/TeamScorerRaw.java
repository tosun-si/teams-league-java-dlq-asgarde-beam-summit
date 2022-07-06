package fr.groupbees.domain;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class TeamScorerRaw implements Serializable {

    private String scorerFirstName;
    private String scorerLastName;
    private int goalsNumber;
    private int gamesNumber;
}
