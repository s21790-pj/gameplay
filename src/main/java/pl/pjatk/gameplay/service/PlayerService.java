package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(int id) {
        List<Player> players = new ArrayList<>();
        players.add(new Player((long) 1, "Payer 1", 100, 18, 5));
        players.add(new Player((long) 2, "Payer 2", 100, 12, 8));
        players.add(new Player((long) 3, "Payer 3", 100, 14, 6));


        players.forEach(player -> player.setMana(10));
//  SECOND WAY
//        for(Player player : players) {
//            player.setMana(10);
//        }

        return players.stream().filter(player -> player.getId() == id).findFirst();

//  SECOND WAY
//        for (Player player : players) {
//            if (player.getId() == id) {
//                return player;
//            }
//        }
//        return new Player();
    }

    public Player save(Player player){
        return playerRepository.save(player);
    }


}
