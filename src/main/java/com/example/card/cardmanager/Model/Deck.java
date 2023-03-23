package com.example.card.cardmanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mtg_deck_cards")
public class Deck {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToMany
    @JoinTable(
            name = "card_table",
            joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private Set<Cards> cards_in_deck = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deck_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Cards cards;

    public Deck(Player player, Cards cards) {
        this.player = player;
        this.cards = cards;
    }

    public Deck() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

//    public int getCard_count() {
//        return card_count;
//    }
//
//    public void setCard_count(int card_count) {
//        this.card_count = card_count;
//    }

    public Set<Cards> getCards_in_deck() {
        return cards_in_deck;
    }

    public void setCards_in_deck(Set<Cards> cards_in_deck) {
        this.cards_in_deck = cards_in_deck;
    }

    public void addCards_in_deck(Cards cards) {
        cards_in_deck.add(cards);
    }
}
