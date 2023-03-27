package com.example.card.cardmanager.Repository;

import com.example.card.cardmanager.Model.Cards;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> {

    Cards findByCardName(String cardName);
//    @Query("SELECT * FROM card_collection WHERE card_collection.card_name = 'Something'")
//    Cards findCardbyName(String card_name);

//    @Query("SELECT * FROM card_collection cc WHERE cc.card_name= ?1")
//    Optional<Cards> findCardsByName(String card_name);
}
