package com.cardmng.crud.services;

import com.cardmng.crud.dto.CardRequestDTO;
import com.cardmng.crud.dto.CardResponseDTO;
import com.cardmng.crud.mapper.CardMapper;
import com.cardmng.crud.model.Card;
import com.cardmng.crud.repository.CardRepository;
import com.cardmng.crud.services.interceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {
    final String NotFoundMessage = "Recurso não encontrado. Id: ";

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    @Transactional(readOnly = true)
    public CardResponseDTO findById(Long id){
        Card result = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NotFoundMessage + id));
        return cardMapper.toDto(result);
    }

    public List<CardResponseDTO> findAll(){
        List<Card> result = cardRepository.findAll();
        List<CardResponseDTO> cardsDto = result.stream().map(x -> cardMapper.toDto(x)).toList();
        return cardsDto;
    }

    @Transactional
    public CardResponseDTO create(CardRequestDTO cardRequestDTO){
        BigDecimal newLimitCard = BigDecimal.valueOf(1000D);
        Card card = new Card(cardRequestDTO.name(), newLimitCard);
        Card savedCard = cardRepository.save(card);
        return cardMapper.toDto(savedCard);
    }

    @Transactional
    public CardResponseDTO update(Long id, CardRequestDTO cardRequestDTO) {
        try {
            Card cardToUpdate = cardRepository.getReferenceById(id);
            cardToUpdate.setName(cardRequestDTO.name());
            cardRepository.save(cardToUpdate);
            return cardMapper.toDto(cardToUpdate);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(NotFoundMessage + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new ResourceNotFoundException(NotFoundMessage + id);
        }
        cardRepository.deleteById(id);
    }
}
