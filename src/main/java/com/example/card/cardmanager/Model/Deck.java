package com.example.card.cardmanager.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mtg_deck_cards")
public class Deck {
    @Column(name = "id")
    private int id;

    @Column(name = "deck_id")
    private int deck_id;

    @Column(name = "card_id")
    private int card_id;

    @Column(name = "card_count")
    private int card_count;

    public Deck(int id, int deck_id, int card_id, int card_count) {
        this.id = id;
        this.deck_id = deck_id;
        this.card_id = card_id;
        this.card_count = card_count;
    }

    public Deck() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(int deck_id) {
        this.deck_id = deck_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getCard_count() {
        return card_count;
    }

    public void setCard_count(int card_count) {
        this.card_count = card_count;
    }
}
