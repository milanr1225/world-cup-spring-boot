package rs.ac.singidunum.world_cup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.world_cup.entity.Team;
import rs.ac.singidunum.world_cup.service.TeamService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService service;

    @GetMapping
    public List<Team> getTeams(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id){
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public Team createTeam(@RequestBody Team entity){
        return service.create(entity);
    }

    @PutMapping(path ="/{id}")
    public Team updateTeam(@PathVariable Integer id,@RequestBody Team entity) {
        return service.update(id, entity);
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTeamById(@PathVariable Integer id) {
        service.delete(id);
    }
}
