package rs.ac.singidunum.world_cup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.world_cup.entity.Player;
import rs.ac.singidunum.world_cup.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService service;

    @GetMapping
    public List<Player> getPlayers(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id){
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player entity){
        return service.create(entity);
    }

    @PutMapping(path ="/{id}")
    public Player updatePlayer(@PathVariable Integer id,@RequestBody Player entity) {
        return service.update(id, entity);
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePlayerById(@PathVariable Integer id) {
        service.delete(id);
    }
}
