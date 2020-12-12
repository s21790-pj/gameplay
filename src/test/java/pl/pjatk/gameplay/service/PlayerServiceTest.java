package pl.pjatk.gameplay.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    // klasa udawana
    @Mock
    private PlayerRepository playerRepository;

    // serwis ktorego chcemy uzyc, w to miejsce wstrzykujemy mock z gory
    @InjectMocks
    private PlayerService playerService;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all here");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before each here");
        //playerRepository.save(new Player());
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each here");
        //playerRepository.deleteAll();
    }

    @Test
    void findAll() {
        //given
        when(playerRepository.findAll()).thenReturn(List.of(new Player("nick",1,2,3)));
        //when
        List<Player> all = playerService.findAll();
        //then
        assertThat(all).isEmpty();
    }

    @Test
    void findById() {
        //given
        when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player()));
        //when
        Optional<Player> player = playerService.findById(1L);
        //then
        assertThat(player).isNotEmpty();
    }

    @Test
    void save(){
        //given
        Player playerNoId = new Player("testPlayerNoId",100,100,100);
        Player playerWithId = new Player(1L,"testPlayerWithId",100,100,100);
        when(playerRepository.save(playerNoId)).thenReturn(playerWithId);
        //when
        Player testPlayer = playerService.save(playerNoId);
        //then
        assertThat(testPlayer.getId()).isEqualTo(1L);
    }

    //do poprawy
    @Test
    void update(){
        //given
        Player playerBeforeUpdate = new Player(1L,"PlayerBeforeUpdate",100,100,100);
        Player playerAfterUpdate = new Player("playerAfterUpdate",200,200,200);
        when(playerService.update(1L, playerAfterUpdate));
        //when
        Player testPlayer = playerService.update(1L, playerAfterUpdate);
        //then
        assertThat(testPlayer).isEqualTo(playerBeforeUpdate);
    }

    @Test
    void delete(){
        //given

        //when
        playerService.deleteById(1L);
        playerService.deleteById(1L);
        //then
        verify(playerRepository, times(2)).deleteById(1L);
    }


}