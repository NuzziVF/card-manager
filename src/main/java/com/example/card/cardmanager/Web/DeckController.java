package com.example.card.cardmanager.Web;


import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Model.Deck;
import com.example.card.cardmanager.Services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/decks")
public class DeckController {
    @Autowired
    private DeckService deckService;


    @GetMapping
    public Iterable<Deck> gettingAllDecks() {
        return deckService.getAllDecks();
    }

    @GetMapping("/{deckId}/deck/{cardId}")
    public Cards addCardToDeck(@PathVariable int deckId, @PathVariable int cardId) {
        return deckService.holderName(deckId, cardId);
    }

    @GetMapping("/{id}/card")
    public List<Deck> deckFromCardId(@PathVariable int id) {
        return deckService.getAllDecksViaCard(id);
    }

    @GetMapping("/{id}/player")
    public List<Deck> deckFromPlayerId(@PathVariable int id) {
        return deckService.getAllDecksViaPlayer(id);
    }
}
