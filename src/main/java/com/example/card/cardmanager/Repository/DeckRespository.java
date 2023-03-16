package com.example.card.cardmanager.Repository;

import com.example.card.cardmanager.Model.Deck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRespository extends CrudRepository<Deck, Integer> {
}
