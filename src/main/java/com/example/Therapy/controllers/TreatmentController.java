package com.example.Therapy.controllers;

import com.example.Therapy.controllers.requests.TreatmentRequest;
import com.example.Therapy.models.Treatment;
import com.example.Therapy.services.TreatmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value="/api")
public class TreatmentController {
    TreatmentService treatmentService;
    public TreatmentController(TreatmentService treatmentService){
        this.treatmentService=treatmentService;
    }
    @GetMapping("/getPatient_id/{id}")
    public Treatment getTreatmentById(@PathVariable Long id){
        return treatmentService.getTreatmentById(id);
    }
    @PostMapping(value = "/saveTreatment", consumes = "application/json")
    public Treatment addTreatment(@RequestBody @Valid TreatmentRequest treatmentRequest){
        return treatmentService.addTreatment(treatmentRequest);
    }
    @DeleteMapping("/deleteTreatment/{id}")
    public void deleteTreatment(@PathVariable Long id){
        treatmentService.deleteTreatment(id);
    }

}
