package com.example.Therapy.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Treatment_id" )
    private long id;
    private TreatmentType type;
    private int period;
    private String name;
    @ManyToMany
    @JoinTable (name = "Treatment",
    joinColumns = {@JoinColumn(name = "Treatment_id")},
    inverseJoinColumns = {@JoinColumn(name = "Drugs_id")}
    )
    private List<Drugs> treatmentDrugs = new ArrayList<>();
    public void addDrugs(Drugs drugs) {treatmentDrugs.add(drugs);}
    public void removeDrugs(Drugs drugs) {treatmentDrugs.remove(drugs);}

}
