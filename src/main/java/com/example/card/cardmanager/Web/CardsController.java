package com.example.card.cardmanager.Web;

import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Repository.CardsRepository;
import com.example.card.cardmanager.Services.CardsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;
    @Autowired
    private CardsService cardsService;


    @GetMapping
    public List<Cards> allCards() {
        List<Cards> cards = cardsService.getAllCards();
        if (cards.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return cards;
    }

    @GetMapping("/one/{id}")
    public Optional<Cards> oneCard(@PathVariable int id) {
        Optional<Cards> card = cardsService.getCardById(id);
        if (!card.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return card;
    }

//    @GetMapping("/name/{cardName}")
//    public Cards getCardName(@PathVariable String cardName) {
//        Cards card = cardsService.getCardByName(cardName);
//        return card;
//    }
//
//    @GetMapping("/{cardName}")
//    public ModelAndView oneViewCard(@PathVariable String cardName) {
//        ModelAndView mav = new ModelAndView("oneCard");
//        Cards list = cardsService.getCardByName(cardName);
//        mav.addObject("oneCard", list);
//        return mav;
//    }
    @RequestMapping(value = "/edit/certain/editing/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> editCardForm(@RequestParam("cardName") String cardName,
                                        @RequestParam("mana_cost") String mana_cost,
                                        @RequestParam("converted_mana_cost") int CMC,
                                        @RequestParam("cardType") String cardType,
                                        @RequestParam("power") int power,
                                        @RequestParam("toughness") int toughness,
                                        @RequestParam("rarity") String rarity,
                                        @PathVariable int id
    ) {
        Cards card = new Cards(cardName, mana_cost, CMC, cardType, power, toughness, rarity);
        cardsService.editCard(id, card);
        return ResponseEntity.status(HttpStatus.CREATED).body("Card edited successfully");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> addCardForm(@RequestParam("cardName") String cardName,
                                        @RequestParam("mana_cost") String mana_cost,
                                        @RequestParam("converted_mana_cost") int CMC,
                                        @RequestParam("cardType") String cardType,
                                        @RequestParam("power") int power,
                                        @RequestParam("toughness") int toughness,
                                        @RequestParam("rarity") String rarity) {
        Cards card = new Cards(cardName, mana_cost, CMC, cardType, power, toughness, rarity);
        cardsService.addCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body("Card created successfully");
    }

    @GetMapping("/edit/certain/{id}")
    public ModelAndView editCardById(@PathVariable int id) {
        Cards card = cardsService.getCardById(id).get();
        ModelAndView mav = new ModelAndView("editCards");
        mav.addObject("card", card);
        return mav;
    }

    @GetMapping("/name")
    public ModelAndView searchByName(@RequestParam("cardName") String cardName) {
        // TODO: Implement search logic using cardName parameter
        Cards searchResults = cardsService.getCardByName(cardName);
        ModelAndView mav = new ModelAndView("searchResults");
        mav.addObject("query", cardName);
        mav.addObject("results", searchResults);
        return mav;
    }

    @GetMapping("/view")
    public ModelAndView viewCards() {
        ModelAndView mav = new ModelAndView("viewCards");
        List<Cards> list = cardsService.getAllCards();
        mav.addObject("cards", list);
        return mav;
    }

    @DeleteMapping("/{id}")
    public void deletecard(@PathVariable int id) {
        Optional<Cards> card = cardsService.removeCardById(id);
        if (card == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView pageDeleteMethod(@PathVariable int id) {
        Optional<Cards> card = cardsService.removeCardById(id);
        if (card == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return viewCards();
    }

    @PostMapping
    public Cards addingCard(@RequestBody @Valid Cards card) {
        cardsService.addCard(card);
        return card;
    }

    @PutMapping("/{id}")
    public void editingCard(@PathVariable int id, @RequestBody @Valid Cards cards) {
        cardsService.editCard(id, cards);
    }

//    @JsonIgnore
//    @PutMapping(path = "{card_name}")
//    public void editingCard(@PathVariable String card_name, @RequestBody @Valid Cards cards) {
//        cardsRepository.findCardsByName(card_name);
//    }
}
