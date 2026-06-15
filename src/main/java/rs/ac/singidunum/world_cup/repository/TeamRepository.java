package rs.ac.singidunum.world_cup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.world_cup.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    List<Team> findAllByDeletedAtIsNull();

    Optional<Team> findOneByTeamIdAndDeletedAtIsNull(Integer id);
}
