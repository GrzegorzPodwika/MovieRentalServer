package pl.podwikagrzegorz.MovieRentalServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import pl.podwikagrzegorz.MovieRentalServer.dao.Dao;
import pl.podwikagrzegorz.MovieRentalServer.model.Movie;
import pl.podwikagrzegorz.MovieRentalServer.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController implements Dao<Movie> {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @PostMapping(path = "/saveMovie")
    public @ResponseBody
    int save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @Override
    @PostMapping(path = "/updateMovie")
    public @ResponseBody
    Movie update(Movie movie) {
        return movieService.update(movie);
    }

    @Override
    @PostMapping(path = "/deleteMovie")
    public void delete(Movie movie) {
        movieService.delete(movie);
    }

    @Override
    @PostMapping(path = "getMovie")
    public @ResponseBody Optional<Movie> get(@RequestBody Integer id) {
        return movieService.get(id);
    }


    @Override
    @GetMapping(path = "getAllMovies")
    public @ResponseBody
    List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping(path = "/getAllMoviesByQuery")
    public @ResponseBody
    List<Movie> getAllMoviesByQuery(@RequestParam("searchMovie") String searchMovie, @RequestParam("genre") String genre ) {
        return movieService.getAllMoviesByQuery(searchMovie, genre);
    }

}
