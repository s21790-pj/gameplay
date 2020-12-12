package pl.pjatk.gameplay.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class DamageServiceTest {

    private final DamageService damageService = new DamageService();

    @Test
    void should_heal(){
        // given
        Player player = new Player("Test player", 100, 100, 10);
        // when
        damageService.heal(player, 5);
        // then
        assertThat(player.getHealth()).isEqualTo(105);
    }

    @Test
    void should_increase_heal(){
        // given
        Player player = new Player("Test player", 100, 100, 10);
        // when
        damageService.heal(player, 5);
        // then
        assertThat(player.getHealth()).isGreaterThan(100);
    }

    @Test
    void should_manaReg(){
        // given
        Player player = new Player("Test player", 100, 100, 10);
        // when
        damageService.manaReg(player, 10);
        // then
        assertThat(player.getMana()).isEqualTo(20);
    }

    @Test
    void should_increase_mana(){
        // given
        Player player = new Player("Test player", 100, 100, 10);
        // when
        damageService.manaReg(player,15);
        // then
        assertThat(player.getMana()).isGreaterThan(10);
    }

    @Test
    void should_attack_boost(){
        // given
        Player player = new Player("Test player", 100, 100, 10);
        // when
        damageService.attackBuff(player, 20);
        // then
        assertThat(player.getAttack()).isEqualTo(120);
    }

    @Test
    void should_increase_attack(){
        // given
        Player player = new Player("Test player", 100, 100, 10);
        // when
        damageService.attackBuff(player, 5);
        // then
        assertThat(player.getAttack()).isGreaterThan(100);
    }
}
