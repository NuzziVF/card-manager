package com.example.card.cardmanager.Services;

import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Model.Deck;
import com.example.card.cardmanager.Repository.CardsRepository;
import com.example.card.cardmanager.Repository.DeckRespository;
import com.example.card.cardmanager.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeckService {

    @Autowired
    private DeckRespository deckRespository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CardsRepository cardsRepository;

    public Iterable<Deck> getAllDecks() {
//        List<Deck> deck = new ArrayList<>();
//        deckRespository.findAll()
//                .forEach(deck::add);
        return deckRespository.findAll();
    }

    public Deck addCardToDeck(int deckId, int cardId) {
        Deck deck = deckRespository.findById(deckId).get();
        Cards cards = cardsRepository.findById(cardId).get();

        deck.addCards_in_deck(cards);
        return deckRespository.save(deck);
    }

    public void editDeck(int id, Deck deck) {
        Optional<Deck> optionalDeck = deckRespository.findById(id);
        if (optionalDeck.isEmpty()) throw new IllegalArgumentException("Invalid Deck ID: " + id);
        Deck existingDeck = optionalDeck.get();
        existingDeck.setPlayer(deck.getPlayer());
        deckRespository.save(existingDeck);
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

//    public List<Deck> getAllDecksViaCard(int cardId) {
//        return deckRespository.findByCards_Id(cardId);
//    }
//
//    public List<Deck> getAllDecksViaPlayer(int PlayerId) {
//        return deckRespository.findByPlayer_Id(PlayerId);
//    }


}
