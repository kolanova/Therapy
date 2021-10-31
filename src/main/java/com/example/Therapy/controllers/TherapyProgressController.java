package com.example.Therapy.controllers;

import com.example.Therapy.controllers.requests.TherapyProgressRequest;
import com.example.Therapy.models.TherapyProgress;
import com.example.Therapy.services.TherapyProgressService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value="/api")
public class TherapyProgressController {
    private final TherapyProgressService therapyProgressService;

    public TherapyProgressController(TherapyProgressService therapyProgressService){
        this.therapyProgressService=therapyProgressService;
    }
    @GetMapping("/therapies/{id}")
    public TherapyProgress getTherapyProgress(@PathVariable Long id){
        return therapyProgressService.getTherapyProgressById(id);
    }
    @PostMapping(value = "/therapy-progresses", consumes = "application/json")
    public TherapyProgress saveTherapyProgress(@RequestBody @Valid TherapyProgressRequest therapyProgressRequest){
        return therapyProgressService.saveTherapyProgress(therapyProgressRequest);
    }
    @PostMapping(value = "/therapies/{therapyId}/treatments/{treatmentId}")
    public TherapyProgress addTreatmentToTherapy(@PathVariable("therapyId") Long  therapyProgressId,
                                                 @PathVariable("treatmentId") Long treatmentId){
        return therapyProgressService.addTreatmentToTherapy(therapyProgressId, treatmentId);
    }
    @DeleteMapping(value = "/therapies/{therapyId}/treatments/{treatmentId}")
    public void deleteTherapyProgress(@PathVariable Long id){
        therapyProgressService.deleteTherapyProgress(id);
    }
    @DeleteMapping("/therapy-progress/{id}")
    public void removeTreatmentFromTherapy(@PathVariable Long therapyProgressId, Long treatmentId){
        therapyProgressService.removeTreatmentFromTherapy(therapyProgressId, treatmentId);
    }
}
