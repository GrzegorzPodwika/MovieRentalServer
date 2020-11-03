package pl.podwikagrzegorz.MovieRentalServer.dao;

import org.springframework.data.repository.CrudRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.Movie;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    //List<Movie> findAllByNameAndGenre();
    List<Movie> findAllByGenre(String genre);
    List<Movie> findAllByNameContaining(String name);
    List<Movie> findAllByNameContainingAndGenre(String name, String genre);
}
