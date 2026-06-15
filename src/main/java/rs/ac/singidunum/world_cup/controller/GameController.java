package rs.ac.singidunum.world_cup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.world_cup.entity.Game;
import rs.ac.singidunum.world_cup.service.GameService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService service;

    @GetMapping
    public List<Game> getGames(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Integer id){
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public Game createGame(@RequestBody Game entity){
        return service.create(entity);
    }

    @PutMapping(path ="/{id}")
    public Game updateGame(@PathVariable Integer id,@RequestBody Game entity) {
        return service.update(id, entity);
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGameById(@PathVariable Integer id) {
        service.delete(id);
    }
}
