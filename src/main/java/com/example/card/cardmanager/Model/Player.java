package com.example.card.cardmanager.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "mtg_players_deck")
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "player_name")
    private String player_name;
    @Column(name = "deck_name")
    private String deck_name;
    @Column(name = "deck_format")
    private String deck_format;

    public Player(String player_name, String deck_name, String deck_format) {
        this.player_name = player_name;
        this.deck_name = deck_name;
        this.deck_format = deck_format;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getDeck_name() {
        return deck_name;
    }

    public void setDeck_name(String deck_name) {
        this.deck_name = deck_name;
    }

    public String getDeck_format() {
        return deck_format;
    }

    public void setDeck_format(String deck_format) {
        this.deck_format = deck_format;
    }
}
