package com.example.Therapy.controllers;

import com.example.Therapy.controllers.requests.PatientRequest;
import com.example.Therapy.models.Patient;
import com.example.Therapy.services.PatientService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(value="/api")
public class PatientController {
    private final PatientService patientService;
    public PatientController(PatientService patientService){
    this.patientService = patientService;
    }
    @GetMapping("/getPatient")
    public List<Patient> getPatient(){
        return patientService.getPatient();
    }
    @GetMapping("/getPatient_id/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }
    @PostMapping(value = "/savePatient", consumes = "application/json")
    public Patient addPatient(@RequestBody @Valid PatientRequest patientRequest){
        return patientService.addPatient(patientRequest);
    }
    @DeleteMapping("/deletePatient/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
    }

}
