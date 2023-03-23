package com.example.card.cardmanager.Model;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mtg_cards")
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @ManyToMany(mappedBy = "cards_in_deck")
    private Set<Deck> decks = new HashSet<>();

    @Column(name = "card_name")
    private String card_name;

    @Column(name = "mana_cost")
    private String mana_cost;

    @Column(name = "converted_mana_cost")
    private int converted_mana_cost;

    @Column(name = "card_type")
    private String card_type;

    @Column(name = "power")
    private int power;

    @Column(name = "toughness")
    private int toughness;

    @Column(name = "rarity")
    private String rarity;

    public Cards(String card_name, String mana_cost, int converted_mana_cost, String card_type, int power, int toughness, String rarity) {
        this.card_name = card_name;
        this.mana_cost = mana_cost;
        this.converted_mana_cost = converted_mana_cost;
        this.card_type = card_type;
        this.power = power;
        this.toughness = toughness;
        this.rarity = rarity;
    }

    public Cards() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(String mana_cost) {
        this.mana_cost = mana_cost;
    }

    public int getConverted_mana_cost() {
        return converted_mana_cost;
    }

    public void setConverted_mana_cost(int converted_mana_cost) {
        this.converted_mana_cost = converted_mana_cost;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

}
