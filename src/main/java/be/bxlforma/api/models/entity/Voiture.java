package be.bxlforma.api.models.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Voiture {

    private long id;
    private String marque;
    private String modele;
    private Status status;

    public enum Status {
        OK,
        REPARATION,
        CASSE
    }

}
