package pl.podwikagrzegorz.MovieRentalServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podwikagrzegorz.MovieRentalServer.dao.MovieRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.Movie;
import pl.podwikagrzegorz.MovieRentalServer.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return CollectionUtils.makeList(movieRepository.findAll());
    }

    public int insertMovie(Movie movie) {
        try {
            movieRepository.save(movie);
            return ServerResponse.OK.getCode();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.ERROR.getCode();
        }
    }

    public int insertListOfMovies(List<Movie> movies) {
        try {
            movieRepository.saveAll(movies);
            return ServerResponse.OK.getCode();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.ERROR.getCode();
        }
    }

    public List<Movie> getAllMoviesByQuery(String searchMovie, String genre) {
        List<Movie> queryResult;

        if (searchMovie.equals("*")) {
            queryResult = movieRepository.findAllByGenre(genre);
        } else if(genre.equals("all")) {
            queryResult = movieRepository.findAllByNameContaining(searchMovie);
        } else {
            queryResult = movieRepository.findAllByNameContainingAndGenre(searchMovie, genre);
        }

        return queryResult;
    }
}
