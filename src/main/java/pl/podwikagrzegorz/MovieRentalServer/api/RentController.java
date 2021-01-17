package pl.podwikagrzegorz.MovieRentalServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podwikagrzegorz.MovieRentalServer.dao.Dao;
import pl.podwikagrzegorz.MovieRentalServer.model.RentedMovie;
import pl.podwikagrzegorz.MovieRentalServer.service.RentService;

import java.util.List;
import java.util.Optional;

@RestController
public class RentController implements Dao<RentedMovie> {
    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @Override
    @PostMapping(path = "/saveRentedMovie")
    public @ResponseBody
    int save(@RequestBody RentedMovie rentedMovie) {
        return rentService.save(rentedMovie);
    }

    @Override
    @PostMapping(path = "/updateRentedMovie")
    public @ResponseBody
    RentedMovie update(@RequestBody RentedMovie rentedMovie) {
        return rentService.update(rentedMovie);
    }

    @Override
    @PostMapping(path = "/deleteRentedMovie")
    public void delete(@RequestBody RentedMovie rentedMovie) {
        rentService.delete(rentedMovie);
    }

    @Override
    @PostMapping(path = "/getRentedMovie")
    public @ResponseBody
    Optional<RentedMovie> get(@RequestBody Integer id) {
        return rentService.get(id);
    }

    @Override
    @GetMapping(path = "/getAllRentedMovies")
    public @ResponseBody
    List<RentedMovie> getAll() {
        return rentService.getAll();
    }

    @PostMapping(path = "/getAllRentedMoviesByUser")
    public @ResponseBody
    List<RentedMovie> getAllRentedMoviesByUserId(@RequestBody Integer userId) {
        return rentService.getAllRentedMoviesByUserId(userId);
    }

}
