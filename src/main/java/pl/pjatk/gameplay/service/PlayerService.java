package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private DamageService damageService;


    public PlayerService(PlayerRepository playerRepository, DamageService damageService) {
        this.playerRepository = playerRepository;
        this.damageService = damageService;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(long id) {
        if (id == 10) {
            throw new RuntimeException("abc");
        } else {
            return playerRepository.findById(id);
        }
    }

//        List<Player> players = new ArrayList<>();
//        players.add(new Player((long) 1, "Payer 1", 100, 18, 5));
//        players.add(new Player((long) 2, "Payer 2", 100, 12, 8));
//        players.add(new Player((long) 3, "Payer 3", 100, 14, 6));
//
//  LAMBDA WAY
//        players.forEach(player -> player.setMana(10));
//  SECOND WAY
//        for(Player player : players) {
//            player.setMana(10);
//        }
//  LAMBDA WAY
//        return players.stream().filter(player -> player.getId() == id).findFirst();
//  SECOND WAY
//        for (Player player : players) {
//            if (player.getId() == id) {
//                return player;
//            }
//        }
//        return new Player();


    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    public Player update(Long id, Player updatedPlayer) {
        if (findById(updatedPlayer.getId()).isPresent()) {
            return playerRepository.save(updatedPlayer);
        } else {
            return null;
        }
    }

//    public Player update(long id, Player playerWithUpdatedProperties){
//        playerWithUpdatedProperties.setId(id);
//        if(playerWithUpdatedProperties.getHealth() != findById(id).get().getHealth()){
//            playerWithUpdatedProperties.setHealth(findById(id).get().getHealth());
//        }
//        return playerRepository.save(playerWithUpdatedProperties);
//    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public Player attack(Long attackerId, Long defenderId) {
        Player attacker = findById(attackerId).get();
        Player defender = findById(defenderId).get();

        defender = damageService.attack(attacker, defender);

        playerRepository.save(defender);

        return defender;
    }

    public void deleteAll() {
        playerRepository.deleteAll();
    }
}
