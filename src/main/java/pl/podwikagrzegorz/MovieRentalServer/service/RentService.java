package pl.podwikagrzegorz.MovieRentalServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podwikagrzegorz.MovieRentalServer.dao.Dao;
import pl.podwikagrzegorz.MovieRentalServer.dao.MovieRepository;
import pl.podwikagrzegorz.MovieRentalServer.dao.RentRepository;
import pl.podwikagrzegorz.MovieRentalServer.dao.UserRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.RentedMovie;
import pl.podwikagrzegorz.MovieRentalServer.utils.ServerResponse;

import java.util.List;
import java.util.Optional;

@Service
public class RentService implements Dao<RentedMovie> {
    private final RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public int save(RentedMovie rentedMovie) {
        rentRepository.save(rentedMovie);
        return ServerResponse.OK.getCode();
    }

    @Override
    public RentedMovie update(RentedMovie rentedMovie) {
        return rentRepository.save(rentedMovie);
    }

    @Override
    public void delete(RentedMovie rentedMovie) {
        rentRepository.delete(rentedMovie);
    }

    @Override
    public Optional<RentedMovie> get(Integer id) {
        return rentRepository.findById(id);
    }

    @Override
    public List<RentedMovie> getAll() {
        return rentRepository.findAll();
    }

    public List<RentedMovie> getAllRentedMoviesByUserId(Integer userId) {
        return rentRepository.findAllByUser_UserId(userId);
    }

/*    public int rentMovie(RentedMovieDTO rentedMovieDTO) {
        try {
            var optionalUser = userRepository.findById(rentedMovieDTO.getUserId());
            var optionalMovie = movieRepository.findById(rentedMovieDTO.getMovieId());
            if (optionalUser.isPresent() && optionalMovie.isPresent()) {
                var user = optionalUser.get();
                var movie = optionalMovie.get();

                RentedMovie rentedMovie = new RentedMovie();
                rentedMovie.setUser(user);
                rentedMovie.setMovie(movie);
                rentedMovie.setRentDate(rentedMovieDTO.getRentDate());
                rentedMovie.setReturnDate(rentedMovieDTO.getReturnDate());
                rentedMovie.setRentFee(rentedMovieDTO.getRentFee());

                rentRepository.save(rentedMovie);
                return ServerResponse.OK.getCode();
            } else {
                return ServerResponse.NOT_FOUND.getCode();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.ERROR.getCode();
        }
    }*/
/*
    private List<Fee> transformRentedMoviesIntoFees(List<RentedMovie> rentedMovies) {
        return rentedMovies.stream().map(rentedMovie -> new Fee(rentedMovie.getRentId(), rentedMovie.getMovie().getMovieId(),
                rentedMovie.getMovie().getName(), rentedMovie.getRentDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                rentedMovie.getReturnDate().format(DateTimeFormatter.ISO_LOCAL_DATE), rentedMovie.getRentFee(), rentedMovie.isPaid()))
                .collect(Collectors.toList());
    }*/

/*    public Integer payReservation(Integer rentId) {
        var selectedRentedMovie = rentRepository.findById(rentId);
        if (selectedRentedMovie.isPresent()) {
            RentedMovie resToUpdate = selectedRentedMovie.get();
            resToUpdate.setPaid(true);
            rentRepository.save(resToUpdate);
            return ServerResponse.OK.getCode();
        } else
            return ServerResponse.ERROR.getCode();
    }*/
}
