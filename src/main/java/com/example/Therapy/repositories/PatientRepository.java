package com.example.Therapy.repositories;

import com.example.Therapy.models.Drugs;
import com.example.Therapy.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
