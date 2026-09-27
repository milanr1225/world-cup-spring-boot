package rs.ac.singidunum.world_cup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.world_cup.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
