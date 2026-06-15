package rs.ac.singidunum.world_cup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.world_cup.entity.Game;
import rs.ac.singidunum.world_cup.repository.GameRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;

    public List<Game> getAll(){
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Game> getById(Integer id){
        return repository.findOneByGameIdAndDeletedAtIsNull(id);
    }

    public Game create(Game entity){
        Game game = new Game();
        game.setHost(entity.getHost());
        game.setGuest(entity.getGuest());
        game.setLocation(entity.getLocation());
        game.setTimeStart(entity.getTimeStart());
        game.setCreatedAt(LocalDateTime.now());
        return repository.save(game);
    }

    public Game update(Integer id, Game entity){
        Game game = getById(id).orElseThrow();
        game.setHost(entity.getHost());
        game.setGuest(entity.getGuest());
        game.setLocation(entity.getLocation());
        game.setTimeStart(entity.getTimeStart());
        game.setUpdatedAt(LocalDateTime.now());
        return repository.save(game);
    }

    public void delete(Integer id){
        Game game = getById(id).orElseThrow();
        game.setDeletedAt(LocalDateTime.now());
        repository.save(game);
    }
}
