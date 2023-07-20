package be.bxlforma.api.models.dto;

import be.bxlforma.api.models.entity.Voiture;
import lombok.Data;

@Data
public class VoitureDTO {

    private String marque;
    private String modele;
    private Voiture.Status status;

    // Ceci est une methode de mapping (voir mapper)
    public Voiture toEntity(){
        Voiture voiture = new Voiture();
        voiture.setMarque( marque );
        voiture.setModele( modele );
        voiture.setStatus( status );
        return voiture;
    }

}
