package rs.ac.singidunum.world_cup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.world_cup.entity.Game;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findAllByDeletedAtIsNull();

    Optional<Game> findOneByGameIdAndDeletedAtIsNull(Integer id);

    List<Game> findByHostTeamId(Integer hostId);

    List<Game> findByGuestTeamId(Integer hostId);
}
