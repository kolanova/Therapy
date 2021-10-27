package com.example.Therapy.repositories;

import com.example.Therapy.models.TherapyProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TherapyProgressRepository extends JpaRepository<TherapyProgress, Long> {
}
