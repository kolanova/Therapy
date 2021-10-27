package com.example.Therapy.services;

import com.example.Therapy.controllers.requests.TherapyProgressRQ;
import com.example.Therapy.models.TherapyProgress;
import com.example.Therapy.models.Treatment;
import com.example.Therapy.repositories.TherapyProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TherapyProgressService {
    @Autowired
    private final TherapyProgressRepository therapyProgressRepository;
    private final TreatmentService treatmentService;

    public TherapyProgressService(TherapyProgressRepository therapyProgressRepository, TreatmentService treatmentService) {
        this.therapyProgressRepository = therapyProgressRepository;
        this.treatmentService = treatmentService;
    }

    public TherapyProgress getTherapyProgressById(Long id){

        return therapyProgressRepository.getById(id);
    }
    public TherapyProgress deleteTherapyProgress(Long id){
        TherapyProgress therapyProgress = getTherapyProgressById(id);
        therapyProgressRepository.delete(therapyProgress);
        return therapyProgress;
    }
    public TherapyProgress saveTherapyProgress(TherapyProgressRQ therapyProgressRQ) {
        String name = therapyProgressRQ.getName();
        TherapyProgress therapyProgress = TherapyProgress
                .builder()
                .name(name)
                .build();
        return therapyProgressRepository.save(therapyProgress);
    }
    public TherapyProgress addTreatmentToTherapy(Long therapyProgressId, Long treatmentId){
        TherapyProgress therapyProgress = getTherapyProgressById(therapyProgressId);
        Treatment treatment = treatmentService.getTreatmentById(treatmentId);
        therapyProgress.addTreatment(treatment);
        return therapyProgress;
    }
    public TherapyProgress removeTreatmentFromTherapy(Long therapyProgressId, Long treatmentId){
        TherapyProgress therapyProgress = getTherapyProgressById(therapyProgressId);
        Treatment treatment = treatmentService.getTreatmentById(treatmentId);
        therapyProgress.removeTreatment(treatment);
        return therapyProgress;
    }

}
