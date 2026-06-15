package rs.ac.singidunum.world_cup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.world_cup.entity.Game;
import rs.ac.singidunum.world_cup.entity.Player;
import rs.ac.singidunum.world_cup.entity.Team;
import rs.ac.singidunum.world_cup.repository.GameRepository;
import rs.ac.singidunum.world_cup.repository.PlayerRepository;
import rs.ac.singidunum.world_cup.repository.TeamRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository repository;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    public List<Team> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Team> getById(Integer id){
        return repository.findOneByTeamIdAndDeletedAtIsNull(id);
    }

    public Team create(Team entity) {
        Team team = new Team();
        team.setName(entity.getName());
        team.setCreatedAt(LocalDateTime.now());
        return repository.save(team);
    }

    public Team update(Integer id, Team entity){
        Team team = getById(id).orElseThrow();
        team.setName(entity.getName());
        team.setUpdatedAt(LocalDateTime.now());
        return repository.save(team);
    }

    public void delete(Integer id) {
        Team team = getById(id).orElseThrow();
        team.setDeletedAt(LocalDateTime.now());

        List<Game> games1 = gameRepository.findByHostTeamId(id);
        games1.forEach(game -> game.setDeletedAt(LocalDateTime.now()));

        List<Game> games2 = gameRepository.findByGuestTeamId(id);
        games2.forEach(game -> game.setDeletedAt(LocalDateTime.now()));

        List<Player> players = playerRepository.findAllByTeamTeamIdAndDeletedAtIsNull(id);
        players.forEach(player -> player.setDeletedAt(LocalDateTime.now()));

        repository.save(team);
    }
}