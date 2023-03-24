package com.example.card.cardmanager.Web;


import com.example.card.cardmanager.Model.Cards;
import com.example.card.cardmanager.Model.Player;
import com.example.card.cardmanager.Services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;
    @GetMapping
    public List<Player> listAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> listOnePlayer(@PathVariable int id) {
        Optional<Player> player = playerService.getPlayerById(id);
        if (!player.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return player;
    }

    @GetMapping("/name/{playerName}")
    public List<Cards> listPlayerByName(@PathVariable String playerName) {
        List<Cards> player = playerService.getPlayerByName(playerName);
        if (player.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return player;
    }

    @PostMapping
    public Player postNewPlayer(@RequestBody @Valid Player player) {
        playerService.addPlayer(player);
        return player;
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        Optional<Player> player = playerService.removePlayerById(id);
        if (player == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public void editingPlayer(@PathVariable int id, @RequestBody @Valid Player player) {
        playerService.editPlayer(id, player);
    }
}
