package rs.ac.singidunum.world_cup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.world_cup.entity.Player;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findAllByDeletedAtIsNull();

    Optional<Player> findOneByPlayerIdAndDeletedAtIsNull(Integer id);
    
    List<Player> findAllByTeamTeamIdAndDeletedAtIsNull(Integer id);
}
