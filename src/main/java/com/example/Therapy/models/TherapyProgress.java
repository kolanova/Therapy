package com.example.Therapy.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
public class TherapyProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TherapyProgress_id" )
    private Long Id;
    private String name;
    @OneToMany
    @JoinColumn(name = "TherapyProgress_id")
    private Set<Patient> patients;
    @ManyToMany
    @JoinTable( name = "TherapyAndTreatment_id",
    joinColumns = {@JoinColumn(name = "TherapyProgress")}, inverseJoinColumns = {@JoinColumn(name="Treatment")}
    )
    private List<Treatment> appliedTreatment = new ArrayList<>();
    public void addTreatment(Treatment treatment)
    {
        appliedTreatment.add(treatment);}
    public void removeTreatment(Treatment treatment)
    {
        appliedTreatment.remove(treatment);}


}
