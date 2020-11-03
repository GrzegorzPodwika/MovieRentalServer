package pl.podwikagrzegorz.MovieRentalServer.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podwikagrzegorz.MovieRentalServer.model.Fee;
import pl.podwikagrzegorz.MovieRentalServer.model.RentedMovie;
import pl.podwikagrzegorz.MovieRentalServer.model.RentedMovieDTO;
import pl.podwikagrzegorz.MovieRentalServer.service.RentService;

import java.util.List;

@RestController
public class RentController {
    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping(path = "/rentMovie")
    public @ResponseBody
    int rentMovie(@RequestBody RentedMovieDTO rentedMovieDTO){
        System.out.println(rentedMovieDTO);
        return rentService.rentMovie(rentedMovieDTO);
    }

    @GetMapping(path = "/rentedMovies/{userId}")
    public @ResponseBody
    List<Fee> getAllRentedMoviesByUserId(@PathVariable(name = "userId") Integer userId) {
        return rentService.getAllRentedMoviesByUserId(userId);
    }

}
