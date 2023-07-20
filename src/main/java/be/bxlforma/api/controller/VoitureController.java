package be.bxlforma.api.controller;

import be.bxlforma.api.models.dto.VoitureDTO;
import be.bxlforma.api.models.entity.Voiture;
import be.bxlforma.api.service.VoitureService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voiture")
public class VoitureController {

    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @PutMapping("/{id}")
    public void changeAll(@PathVariable int id, VoitureDTO voitureDTO){
        voitureService.update( id, voitureDTO.toEntity() );
    }

    @PatchMapping("/{id}")
    public void changeStatus(@PathVariable int id, @RequestParam Voiture.Status status){
        this.voitureService.updateStatus(id, status);
    }


}
