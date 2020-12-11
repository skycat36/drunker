package com.vsu.drunker.web.data.errors;

import lombok.Data;

import java.util.Map;

@Data
public class BadRequestDTO {

    private String message;

    private Map<String, String> errors;

    public BadRequestDTO(String message) {
        this.message = message;
    }

    public BadRequestDTO(Map<String, String> errors) {
        this.errors = errors;
    }

    public BadRequestDTO() {
    }
}
