package rs.ac.singidunum.world_cup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.world_cup.entity.Player;
import rs.ac.singidunum.world_cup.repository.PlayerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;

    public List<Player> getAll(){
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Player> getById(Integer id){
        return repository.findOneByPlayerIdAndDeletedAtIsNull(id);
    }

    public Player create(Player entity){
        Player player = new Player();
        player.setName(entity.getName());
        player.setPosition(entity.getPosition());
        player.setTeam(entity.getTeam());
        player.setCreatedAt(LocalDateTime.now());
        return repository.save(player);
    }

    public Player update(Integer id, Player entity){
        Player player = getById(id).orElseThrow();
        player.setName(entity.getName());
        player.setPosition(entity.getPosition());
        player.setTeam(entity.getTeam());
        player.setUpdatedAt(LocalDateTime.now());
        return repository.save(player);
    }

    public void delete(Integer id){
        Player player = getById(id).orElseThrow();
        player.setDeletedAt(LocalDateTime.now());
        repository.save(player);
    }

}
