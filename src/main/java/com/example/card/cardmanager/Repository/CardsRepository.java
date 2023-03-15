package com.example.card.cardmanager.Repository;

import com.example.card.cardmanager.Model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> {
}
