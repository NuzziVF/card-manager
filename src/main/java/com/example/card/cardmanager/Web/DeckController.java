package com.example.card.cardmanager.Web;


import com.example.card.cardmanager.Model.Deck;
import com.example.card.cardmanager.Services.DeckService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/decks")
public class DeckController {
    @Autowired
    private DeckService deckService;


    @GetMapping
    public Iterable<Deck> gettingAllDecks() {
        return deckService.getAllDecks();
    }

    @GetMapping("/{id}")
    public Deck gettingADeck(@PathVariable int id) {
        return deckService.getOneDeck(id).get();
    }

    @PutMapping("/{deckId}/deck/{cardId}")
    public Deck addCardToDeckPage(@PathVariable int deckId, @PathVariable int cardId) {
        return deckService.addCardToDeck(deckId, cardId);
    }

    @PutMapping("/{deckId}/edit")
    public void editPlayer(@PathVariable int deckId, @RequestBody @Valid Deck deck) {
        deckService.editDeck(deckId, deck);
    }

//    @GetMapping("/{id}/player")
//    public List<Deck> deckFromPlayerId(@PathVariable int id) {
//        return deckService.getAllDecksViaPlayer(id);
//    }

    @PostMapping
    public Deck postNewDeck(@RequestBody @Valid Deck deck) {
        deckService.addDeck(deck);
        return deck;
    }

    @DeleteMapping("/{id}")
    public void deleteDeck(@PathVariable int id) {
        Optional<Deck> deck = deckService.removeDeckById(id);
        if (deck == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
