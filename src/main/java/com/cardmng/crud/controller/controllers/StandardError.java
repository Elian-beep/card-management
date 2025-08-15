package com.cardmng.crud.controller.controllers;

import java.io.Serializable;
import java.time.Instant;

public record StandardError(
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) implements Serializable {
    private static final long serialVersionUID = 1L;
}
