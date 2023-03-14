package com.example.card.cardmanager.Services;


import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardsService {
    @Autowired
    private CardsRepository cardsRepository;


    public List<Cards> getAllCards() {
        List<Cards> cards = new ArrayList<>();
        cardsRepository.findAll()
                .forEach(cards::add);
        return cards;
    }
}
