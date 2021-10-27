package com.example.Therapy.controllers.requests;

import com.example.Therapy.models.TreatmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TreatmentRQ {
    private String name;
    private int period;
    private TreatmentType type;
}
