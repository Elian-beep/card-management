package com.cardmng.crud.mapper;

import com.cardmng.crud.dto.CardResponseDTO;
import com.cardmng.crud.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);
    CardResponseDTO toDto(Card card);
    Card toEntity(CardResponseDTO cardResponseDTO);
}
