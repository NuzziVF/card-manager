package com.example.card.cardmanager.Services;


import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Cards> getCardById(int id) {
        return cardsRepository.findById(id);
    }

    public Optional<Cards> removeCardById(int id) {
        Optional<Cards> optionalCard = cardsRepository.findById(id);
        if (optionalCard.isPresent()) {
            cardsRepository.deleteById(id);
            return optionalCard;
        } else {
            return null;
        }
    }

    public Cards addCard(Cards card) {
        return cardsRepository.save(card);
    }


}
