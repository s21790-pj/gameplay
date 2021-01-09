package pl.pjatk.gameplay.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.gameplay.model.Player;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
public class PlayerServiceTestIT {

    @Autowired
    private PlayerService playerService;

    @BeforeEach
    void cleanService() {
        playerService.deleteAll();
    }

    @Test
    void shouldBeEmpty() {
        List<Player> all = playerService.findAll();
        assertThat(all).isEmpty();
    }

    @Test
    void ShouldNotBeEmpty() {
        Player player = new Player("nickname", 100, 10, 10);
        Player save = playerService.save(player);
        List<Player> all = playerService.findAll();
        assertThat(all).isNotEmpty();

    }

    @Test
    void ShouldHaveId() {
        Player player = new Player("nickname", 100, 10, 10);
        Player save = playerService.save(player);
        assertThat(save.getId()).isEqualTo(1);
    }

    @Test
    void ShouldAttack() {
        Player player_one = new Player("nickname", 100, 10, 10);
        Player player_two = new Player("nickname_2", 100, 10, 10);

        Player save_one = playerService.save(player_one);
        Player save_two = playerService.save(player_two);

        playerService.attack(save_one.getId(), save_two.getId());

        assertThat(playerService.findById(save_two.getId()).get().getHealth()).isEqualTo(90);
    }

    @Test
    void shouldAddPlayerToDB() {
        Player player = new Player("nickname", 100, 10, 10);
        Player save = playerService.save(player);
        assertThat(save.getId()).isNotNull();
    }

    @Test
    void shouldThrowException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> playerService.findById(10));
    }
}
