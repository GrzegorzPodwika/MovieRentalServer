package pl.podwikagrzegorz.MovieRentalServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podwikagrzegorz.MovieRentalServer.dao.Dao;
import pl.podwikagrzegorz.MovieRentalServer.dao.MovieRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.Movie;
import pl.podwikagrzegorz.MovieRentalServer.utils.ServerResponse;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements Dao<Movie> {

    private final MovieRepository repo;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.repo = movieRepository;
    }

    @Override
    public int save(Movie movie) {
        repo.save(movie);
        return ServerResponse.OK.getCode();
    }

    @Override
    public Movie update(Movie movie) {
        return repo.save(movie);
    }

    @Override
    public void delete(Movie movie) {
        repo.delete(movie);
    }

    @Override
    public Optional<Movie> get(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<Movie> getAll() {
        return repo.findAll();
    }

    public List<Movie> getAllMoviesByQuery(String searchMovie, String genre) {
        List<Movie> queryResult;

        if (searchMovie.equals("*")) {
            queryResult = repo.findAllByGenre(genre);
        } else if(genre.equals("all")) {
            queryResult = repo.findAllByNameContaining(searchMovie);
        } else {
            queryResult = repo.findAllByNameContainingAndGenre(searchMovie, genre);
        }

        return queryResult;
    }
}
