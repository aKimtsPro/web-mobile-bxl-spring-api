package be.bxlforma.api.service;

import be.bxlforma.api.models.entity.Voiture;

import java.util.List;

public interface VoitureService {

    List<Voiture> getAll();
    Voiture getOne(int id);
    void add(Voiture toAdd);
    void update(int id, Voiture updateData);
    void updateStatus(int id, Voiture.Status status);

}
