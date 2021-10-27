package com.example.Therapy.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
public class Drugs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Drugs_id" )
    private long Id;
    private String drug;
    public String drugName;
    @ManyToMany(mappedBy = "makingTreatment")
    private List<Treatment> completeTreatment = new ArrayList<>();
}
