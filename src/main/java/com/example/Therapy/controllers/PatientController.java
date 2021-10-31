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
    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }
    @PostMapping(value = "/patients", consumes = "application/json")  //here we add only one
    public Patient addPatient(@RequestBody @Valid PatientRequest patientRequest){
        return patientService.addPatient(patientRequest);
    }
    @GetMapping("/patients/{id}")  //here the path is a resource
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
    }

}
