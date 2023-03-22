package com.example.card.cardmanager.Web;


import com.example.card.cardmanager.Model.Deck;
import com.example.card.cardmanager.Services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeckController {
    @Autowired
    private DeckService deckService;

    @GetMapping("/decks/{id}/card")
    public List<Deck> deckFromCardId(@PathVariable int id) {
        return deckService.getAllDecksViaCard(id);
    }

    @GetMapping("/decks/{id}/player")
    public List<Deck> deckFromPlayerId(@PathVariable int id) {
        return deckService.getAllDecksViaPlayer(id);
    }
}
