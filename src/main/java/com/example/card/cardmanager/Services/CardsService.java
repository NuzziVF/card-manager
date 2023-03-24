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

    public List<Cards> viewAllCards() {
        List<Cards> every_card = new ArrayList<>();
        cardsRepository.findAll()
                .forEach(every_card::add);
        return every_card;
    }

    public List<Cards> getCardByName(String cardName) {
        return cardsRepository.findByCardName(cardName);
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


    public void editCard(int id, Cards cards) {
        Optional<Cards> optionalCards = cardsRepository.findById(id);
        if (optionalCards.isEmpty()) throw new IllegalArgumentException("Invalid Card ID: " + id);
        Cards existingCard = optionalCards.get();
        existingCard.setCardName(cards.getCardName());
        existingCard.setCard_type(cards.getCard_type());
        existingCard.setPower(cards.getPower());
        existingCard.setToughness(cards.getToughness());
        existingCard.setRarity(cards.getRarity());
        existingCard.setConverted_mana_cost(cards.getConverted_mana_cost());
        existingCard.setMana_cost(cards.getMana_cost());
        cardsRepository.save(existingCard);
    }

}
