package com.example.Therapy.services;

import com.example.Therapy.controllers.requests.PatientRequest;
import com.example.Therapy.exceptions.PatientNotFoundException;
import com.example.Therapy.models.Patient;
import com.example.Therapy.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }
    public Patient addPatient(PatientRequest patientRequest){
        String firstName= patientRequest.getFirstName();
        String lastName= patientRequest.getLastName();
        String phone= patientRequest.getPhone();
        String email = patientRequest.getEmail();
        Patient patient = Patient
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .phone(phone)
                .email(email)
                .build();
        return patientRepository.save(patient);
    }
    public Patient getPatientById(Long id){
        return patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(
                "Patient not found"));
    }

    public Patient deletePatientById(Long id){
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
        return patient;
    }
    public Patient editPatient(Long id, Patient patient){
        Patient patientToEdit = getPatientById(id);
        patientToEdit.setFirstName(patient.getFirstName());
        patientToEdit.setLastName(patient.getLastName());
        patientToEdit.setPhone(patient.getPhone());
        patientToEdit.setEmail(patient.getEmail());
        return patientToEdit;
    }
}
