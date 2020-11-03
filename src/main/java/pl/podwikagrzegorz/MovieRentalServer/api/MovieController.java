package pl.podwikagrzegorz.MovieRentalServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import pl.podwikagrzegorz.MovieRentalServer.model.Movie;
import pl.podwikagrzegorz.MovieRentalServer.service.MovieService;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/addMovie")
    public @ResponseBody
    int insertMovie(@RequestBody Movie movie) {
        return movieService.insertMovie(movie);
    }

    @PostMapping(path = "/addMovies")
    public @ResponseBody
    int insertListOfMovies(@RequestBody List<Movie> movies) {
        return movieService.insertListOfMovies(movies);
    }

    @GetMapping(path = "/getAllMovies")
    public @ResponseBody
    List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(path = "/movies")
    public @ResponseBody
    List<Movie> getAllMoviesByQuery(@RequestParam("searchMovie") String searchMovie, @RequestParam("genre") String genre ) {
        return movieService.getAllMoviesByQuery(searchMovie, genre);
    }
}
