package com.example.card.cardmanager.Model;

public class Player {

    private int id;
    private String player_name;
    private String deck_name;
    private String deck_format;

    public Player(int id, String player_name, String deck_name, String deck_format) {
        this.id = id;
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
