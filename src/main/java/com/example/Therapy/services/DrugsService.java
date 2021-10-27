package com.example.Therapy.services;

import com.example.Therapy.controllers.requests.DrugsRQ;
import com.example.Therapy.models.Drugs;
import com.example.Therapy.repositories.DrugsRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DrugsService {
    private final DrugsRepository drugsRepository;
    public DrugsService(DrugsRepository drugsRepository) {this.drugsRepository = drugsRepository;
    }
    public Drugs addDrugs(DrugsRQ drugsRQ){
        String drugName = drugsRQ.getDrugName();
        String drug = drugsRQ.getDrug();
        Drugs drugs = Drugs.builder().drugName(drugName).drug(drug).build();
        return drugsRepository.save(drugs);
    }
    public List<Drugs> detAllDrugs()
        {return drugsRepository.findAll();}
    public Drugs getDrugsById(Long id)
        {return (Drugs) drugsRepository.findAllById(Collections.singleton(id));}
    public Drugs deleteDrugs(Long id)
        {Drugs drugs = getDrugsById(id);
        drugsRepository.delete(drugs);
    return drugs;}
}
