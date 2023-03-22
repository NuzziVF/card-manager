package com.example.card.cardmanager.Services;

import com.example.card.cardmanager.Model.Deck;
import com.example.card.cardmanager.Repository.DeckRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckService {

    @Autowired
    private DeckRespository deckRespository;

    public List<Deck> getAllDecks() {
        List<Deck> deck = new ArrayList<>();
        deckRespository.findAll()
                .forEach(deck::add);
        return deck;
    }

    public List<Deck> getAllDecksViaCard(int cardId) {
        return deckRespository.findByCards_Id(cardId);
    }

    public List<Deck> getAllDecksViaPlayer(int PlayerId) {
        return deckRespository.findByPlayer_Id(PlayerId);
    }


}
