package com.example.card.cardmanager.Repository;

import com.example.card.cardmanager.Model.Deck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRespository extends CrudRepository<Deck, Integer> {
    List<Deck> findByCards_Id(int postId);
    List<Deck> findByPlayer_Id(int postId);
}

