package com.example.Therapy.controllers;

import com.example.Therapy.controllers.requests.DrugsRequest;
import com.example.Therapy.models.Drugs;
import com.example.Therapy.services.DrugsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@Validated
public class DrugsController {
    DrugsService drugsService;
    public DrugsController(DrugsService drugsService){
        this.drugsService = drugsService;
    }
    @GetMapping("/drugs")
    public List<Drugs> getAllDrugs(){
        return drugsService.getAllDrugs();
    }

    @PostMapping(value = "/saveDrugs", consumes = "application/json")
    public Drugs addDrugs(@RequestBody @Valid DrugsRequest drugsRequest){
        return drugsService.addDrugs(drugsRequest);
    }
    @DeleteMapping("/deleteDrugs/{id}")
    public void deleteDrugs(@PathVariable Long id){
        drugsService.deleteDrugs(id);
    }
}
