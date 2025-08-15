package com.cardmng.crud.controller;

import com.cardmng.crud.dto.CardRequestDTO;
import com.cardmng.crud.dto.CardResponseDTO;
import com.cardmng.crud.services.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/card")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CardResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(cardService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CardResponseDTO>> findAll(){
        return ResponseEntity.ok(cardService.findAll());
    }

    @PostMapping
    public ResponseEntity<CardResponseDTO> create(@RequestBody @Valid CardRequestDTO cardRequestDTO){
        CardResponseDTO newCardDto = cardService.create(cardRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newCardDto.id()).toUri();
        return ResponseEntity.created(uri).body(newCardDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CardResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CardRequestDTO cardRequestDTO){
        return ResponseEntity.ok(cardService.update(id, cardRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
