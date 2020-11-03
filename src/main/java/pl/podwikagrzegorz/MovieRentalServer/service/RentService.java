package pl.podwikagrzegorz.MovieRentalServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podwikagrzegorz.MovieRentalServer.dao.MovieRepository;
import pl.podwikagrzegorz.MovieRentalServer.dao.RentRepository;
import pl.podwikagrzegorz.MovieRentalServer.dao.UserRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.Fee;
import pl.podwikagrzegorz.MovieRentalServer.model.RentedMovie;
import pl.podwikagrzegorz.MovieRentalServer.model.RentedMovieDTO;
import pl.podwikagrzegorz.MovieRentalServer.model.User;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentService {
    private final RentRepository rentRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Autowired
    public RentService(RentRepository rentRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.rentRepository = rentRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public int rentMovie(RentedMovieDTO rentedMovieDTO) {
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
    }

    public List<Fee> getAllRentedMoviesByUserId(Integer userId) {
        List<RentedMovie> rentedMovies = rentRepository.findAllByUser_UserId(userId);
        return transformRentedMoviesIntoFees(rentedMovies);
    }

    private List<Fee> transformRentedMoviesIntoFees(List<RentedMovie> rentedMovies) {
        return rentedMovies.stream().map(rentedMovie -> new Fee(rentedMovie.getRentId(), rentedMovie.getMovie().getMovieId(), rentedMovie.getMovie().getName(), rentedMovie.getRentDate().format(DateTimeFormatter.ISO_LOCAL_DATE), rentedMovie.getReturnDate().format(DateTimeFormatter.ISO_LOCAL_DATE), rentedMovie.getRentFee()))
                .collect(Collectors.toList());
    }
}
