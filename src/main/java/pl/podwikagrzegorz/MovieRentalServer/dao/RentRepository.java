package pl.podwikagrzegorz.MovieRentalServer.dao;

import org.springframework.data.repository.CrudRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.RentedMovie;

import java.util.List;

public interface RentRepository extends CrudRepository<RentedMovie, Integer> {

    List<RentedMovie> findAllByUser_UserId(Integer userId);
}
