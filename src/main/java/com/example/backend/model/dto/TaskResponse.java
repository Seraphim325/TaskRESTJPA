package com.example.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@ToString
public class TaskResponse {
    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime createdAt;

}
