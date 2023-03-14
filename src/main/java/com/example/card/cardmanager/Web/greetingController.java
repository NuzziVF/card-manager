package com.example.card.cardmanager.Web;

import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class greetingController {

    @Autowired
    private CardsService cardsService;

    @GetMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    @GetMapping("/cards")
    public List<Cards> allCards() {
        return cardsService.getAllCards();
    }

}
