package com.example.card.cardmanager.Web;

import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Repository.CardsRepository;
import com.example.card.cardmanager.Services.CardsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/cards")
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;
    @Autowired
    private CardsService cardsService;

    @GetMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    @GetMapping("/all")
    public List<Cards> allCards() {
        List<Cards> cards = cardsService.getAllCards();
        if (cards.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return cards;
    }

    @GetMapping("/cards/{id}")
    public Optional<Cards> oneCard(@PathVariable int id) {
        Optional<Cards> card = cardsService.getCardById(id);
        if (!card.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return card;
    }


    @GetMapping("/view")
    public ModelAndView viewCards() {
        ModelAndView mav = new ModelAndView("adminCards");
        List<Cards> list = cardsService.getAllCards();
        mav.addObject("cards", list);
        return mav;
    }

    @DeleteMapping("/cards/{id}")
    public void deletecard(@PathVariable int id) {
        Optional<Cards> card = cardsService.removeCardById(id);
        if (card == null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/cards")
    public Cards addingCard(@RequestBody @Valid Cards card) {
        cardsService.addCard(card);
        return card;
    }

    @PutMapping("/cards/{id}")
    public void editingCard(@PathVariable int id, @RequestBody @Valid Cards cards) {
        cardsService.editCard(id, cards);
    }
}
