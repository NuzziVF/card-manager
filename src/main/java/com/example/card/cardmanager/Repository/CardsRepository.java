package com.example.card.cardmanager.Repository;

import com.example.card.cardmanager.Model.Cards;
import org.springframework.data.repository.CrudRepository;

public interface CardsRepository extends CrudRepository<Cards, Integer> {
    Iterable<Cards> findAll();
}
