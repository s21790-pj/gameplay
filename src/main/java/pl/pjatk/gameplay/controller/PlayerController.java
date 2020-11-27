package pl.pjatk.gameplay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.DamageService;
import pl.pjatk.gameplay.service.PlayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private DamageService damageService;

    public PlayerController(PlayerService playerService, DamageService damageService) {
        this.playerService = playerService;
        this.damageService = damageService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Player>> findById(@PathVariable long id) {
        Optional<Player> byId = playerService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.save(player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@PathVariable long id, @RequestBody Player playerWithUpdatedProperties) {
        return ResponseEntity.ok(playerService.update(id, playerWithUpdatedProperties));
    }

    @PutMapping("/{id}/{id_2}")
    public ResponseEntity<Player> attack(@PathVariable long id, @PathVariable long id_2){
        return ResponseEntity.ok(damageService.playerAttack(id, id_2));
    }

}
