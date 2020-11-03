package pl.podwikagrzegorz.MovieRentalServer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;

    private String name;

    private String genre;

    private String year;

    private double rating;

    private double feePerDay;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer id) {
        this.movieId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getFeePerDay() {
        return feePerDay;
    }

    public void setFeePerDay(double fee_per_day) {
        this.feePerDay = fee_per_day;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movieId +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                ", fee_per_day=" + feePerDay +
                '}';
    }
}
