package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

import java.util.Optional;

@Service
public class DamageService {

    private PlayerService playerService;

    public DamageService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Player playerAttack(long offensiveId, long defenderId) {
        Optional<Player> optionalOffensive = playerService.findById(offensiveId);
        Optional<Player> optionalDefender = playerService.findById(defenderId);

        if (optionalOffensive.isPresent() && optionalDefender.isPresent()) {
            int attack = optionalOffensive.get().getAttack();
            Player defender = optionalDefender.get();
            int health = defender.getHealth();

            defender.setHealth(health - attack);
            playerService.save(defender);

            return defender;

        } else {
            return null;
        }

    }
}
