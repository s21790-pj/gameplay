package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

@Service
public class DamageService {

//    private PlayerService playerService;
//
//    public DamageService(PlayerService playerService) {
//        this.playerService = playerService;
//    }
//
//    public Player playerAttack(long offensiveId, long defenderId) {
//        Optional<Player> optionalOffensive = playerService.findById(offensiveId);
//        Optional<Player> optionalDefender = playerService.findById(defenderId);
//
//        if (optionalOffensive.isPresent() && optionalDefender.isPresent()) {
//            int attack = optionalOffensive.get().getAttack();
//            Player defender = optionalDefender.get();
//            int health = defender.getHealth();
//
//            defender.setHealth(health - attack);
//            playerService.save(defender);
//
//            return defender;
//
//        } else {
//            return null;
//        }
//    }

    private DamageService damageService;


    public Player heal(Player player, int heal_value) {
        player.setHealth(player.getHealth() + heal_value);
        if (player.getHealth() <= 0) {
            throw new RuntimeException();
        }
        return player;
    }

    public Player manaReg(Player player, int reg_value) {
        player.setMana(player.getMana() + reg_value);
        return player;
    }

    public Player attackBuff(Player player, int boost_value) {
        player.setAttack(player.getAttack() + boost_value);
        return player;
    }

    public Player attack(Player attacker, Player defender) {
        defender.setHealth(
                defender.getHealth() - attacker.getAttack()
        );
        return defender;
    }


}
