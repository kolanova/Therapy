package com.example.Therapy.repositories;

import com.example.Therapy.models.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugsRepository extends JpaRepository<Drugs, Long> {
}
