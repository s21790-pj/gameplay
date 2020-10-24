package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

import java.util.List;

@Service
public class PlayerService {

    public List<Player> findAll(){
        return List.of(
                new Player("Payer 1", 100, 18, 5),
                new Player("Payer 2", 100, 12, 8),
                new Player("Payer 3", 100, 14, 6));
    }
}
