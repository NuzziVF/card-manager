package com.example.card.cardmanager.Repository;

import com.example.card.cardmanager.Model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
