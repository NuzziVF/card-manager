package com.example.card.cardmanager.Repository;

import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    List<Cards> findByPlayerName(String playerName);
}
