package com.example.card.cardmanager.Services;

import com.example.card.cardmanager.Model.Player;
import com.example.card.cardmanager.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll()
                .forEach(players::add);
        return players;
    }

    public Optional<Player> getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    public Player getPlayerByName(String playerName) {
        return (Player) playerRepository.findByPlayerName(playerName);
    }

    public Optional<Player> removePlayerById(int id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            playerRepository.deleteById(id);
            return optionalPlayer;
        } else {
            return null;
        }
    }


    public Player addPlayer(Player player) { return playerRepository.save(player); }

    public void editPlayer(int id, Player player) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) throw new IllegalArgumentException("Invalid Player ID");
        Player existingCard = optionalPlayer.get();
        existingCard.setPlayerName(player.getPlayerName());
        existingCard.setDeck_name(player.getDeck_name());
        existingCard.setDeck_format(player.getDeck_format());
        playerRepository.save(existingCard);
    }
}
