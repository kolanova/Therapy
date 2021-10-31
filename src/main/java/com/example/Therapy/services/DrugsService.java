package com.example.Therapy.services;

import com.example.Therapy.controllers.requests.DrugsRequest;
import com.example.Therapy.models.Drugs;
import com.example.Therapy.repositories.DrugsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DrugsService {
    @Autowired
    private final DrugsRepository drugsRepository;
    public DrugsService(DrugsRepository drugsRepository) {this.drugsRepository = drugsRepository;
    }
    public Drugs addDrugs(DrugsRequest drugsRequest){
        String drugName = drugsRequest.getDrugName();
        String drug = drugsRequest.getDrug();
        Drugs drugs = Drugs.builder().drugName(drugName).drug(drug).build();
        return drugsRepository.save(drugs);
    }
    public List<Drugs> getAllDrugs()
        {return drugsRepository.findAll();}

    public Drugs getDrugsById(Long id)
        {return drugsRepository.getById(id);}

    public Drugs deleteDrugs(Long id)
        {Drugs drugs = getDrugsById(id);
        drugsRepository.delete(drugs);
    return drugs;}
}
