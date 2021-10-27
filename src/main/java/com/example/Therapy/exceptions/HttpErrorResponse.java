package com.example.Therapy.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HttpErrorResponse {
    private int status;
    private String Error;
    private LocalDateTime timestamp;
}
