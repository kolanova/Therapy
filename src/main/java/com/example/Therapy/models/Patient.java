package com.example.Therapy.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private long Id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @ManyToOne
    @JoinColumn(name = "TherapyProgressBy_Id")
    private TherapyProgress therapyProgress;
}
