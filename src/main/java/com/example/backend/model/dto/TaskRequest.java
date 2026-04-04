package com.example.backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    @NotBlank(message = "Title is required")
    @Size(max = 255)
    private String title;

    @Size(max = 65535)
    private String description;

    private Boolean completed;
}
