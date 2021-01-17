package pl.podwikagrzegorz.MovieRentalServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
