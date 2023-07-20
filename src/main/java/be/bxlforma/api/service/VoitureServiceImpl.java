package be.bxlforma.api.service;

import be.bxlforma.api.models.entity.Voiture;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {

    private List<Voiture> voitures = new ArrayList<>();

    @Override
    public List<Voiture> getAll() {
        return List.copyOf(voitures);
    }

    @Override
    public void add(Voiture toAdd) {
        voitures.add(toAdd);
    }

    @Override
    public Voiture getOne(int id) {
        return voitures.stream()
                .filter( task -> task.getId() == id )
                .findAny()
                .orElseThrow();
    }

    @Override
    public void update(int id, Voiture updateData) {
        Voiture toUpdate = getOne(id);
        toUpdate.setMarque( updateData.getMarque() );
        toUpdate.setModele( updateData.getModele() );
        toUpdate.setStatus( updateData.getStatus() );
    }

    @Override
    public void updateStatus(int id, Voiture.Status status) {
        Voiture toUpdate = getOne(id);
        toUpdate.setStatus( status );
    }
}
