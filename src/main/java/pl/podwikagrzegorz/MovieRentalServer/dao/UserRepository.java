package pl.podwikagrzegorz.MovieRentalServer.dao;

import org.springframework.data.repository.CrudRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.User;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
