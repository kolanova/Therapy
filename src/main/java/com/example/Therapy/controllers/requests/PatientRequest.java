package com.example.Therapy.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PatientRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
