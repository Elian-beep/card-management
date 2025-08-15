package com.cardmng.crud.dto;

import com.cardmng.crud.model.Card;

public record CardResponseDTO(Long id, String name, Double limitCard, Double invoice) {}