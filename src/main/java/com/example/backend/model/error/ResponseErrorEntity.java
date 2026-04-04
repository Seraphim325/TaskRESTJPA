package com.example.backend.model.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseErrorEntity (
        LocalDateTime timestamp,
        HttpStatus status,
        String message,
        String path
) { }
