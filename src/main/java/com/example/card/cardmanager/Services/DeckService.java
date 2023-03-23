package com.example.card.cardmanager.Services;

import com.example.card.cardmanager.Model.Deck;
import com.example.card.cardmanager.Repository.DeckRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Deck> getOneDeck(int id) {
        return deckRespository.findById(id);
    }

    public Optional<Deck> removeDeckById(int id) {
        Optional<Deck> optionalDeck = deckRespository.findById(id);
        if (optionalDeck.isPresent()) {
            deckRespository.deleteById(id);
            return optionalDeck;
        } else {
            return null;
        }
    }

    public Deck addDeck(Deck deck) {
        return deckRespository.save(deck);
    }

    public List<Deck> getAllDecksViaCard(int cardId) {
        return deckRespository.findByCards_Id(cardId);
    }

    public List<Deck> getAllDecksViaPlayer(int PlayerId) {
        return deckRespository.findByPlayer_Id(PlayerId);
    }


}
