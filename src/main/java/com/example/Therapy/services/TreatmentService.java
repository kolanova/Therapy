package com.example.Therapy.services;
import com.example.Therapy.controllers.requests.TreatmentRequest;
import com.example.Therapy.models.Drugs;
import com.example.Therapy.models.TreatmentType;
import com.example.Therapy.models.Treatment;
import com.example.Therapy.repositories.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    private final TreatmentRepository treatmentRepository;
    private final DrugsService drugsService;
    private Long drugsId;

    public TreatmentService(TreatmentRepository treatmentRepository, DrugsService drugsService){
        this.treatmentRepository = treatmentRepository;
        this.drugsService = drugsService;
    }
    public Treatment addTreatment(TreatmentRequest treatmentRequest){
        String name = treatmentRequest.getName();
        TreatmentType Type = treatmentRequest.getType();
        int period = treatmentRequest.getPeriod();
        Treatment treatment = Treatment
                .builder()
                .name(name)
                .build();
        return treatmentRepository.save(treatment);
    }
    public List<Treatment> getProcedures(){
        return treatmentRepository.findAll();
    }
    public Treatment getTreatmentById(Long id){
        return (Treatment) treatmentRepository.getById(id);
    }
    public Treatment deleteTreatment(Long id){
        Treatment treatment= getTreatmentById(id);
        treatmentRepository.delete(treatment);
        return treatment;
    }
    public Treatment addDrugsToTreatment(Long Id, Long treatmentId){
        Treatment treatment = getTreatmentById(treatmentId);
        Drugs drugs = drugsService.getDrugsById(drugsId);
        treatment.addDrugs(drugs);
        return treatment;
    }
    public Treatment removeDrugsFromTreatment(Long Id, Long treatmentId){
        Treatment treatment = getTreatmentById(treatmentId);
        Drugs drugs = drugsService.getDrugsById(treatmentId);
        treatment.removeDrugs(drugs);
        return treatment;
    }

}
