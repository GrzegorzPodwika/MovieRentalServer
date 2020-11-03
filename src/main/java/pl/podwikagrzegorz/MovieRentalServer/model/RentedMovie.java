package pl.podwikagrzegorz.MovieRentalServer.model;

import javax.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
public class RentedMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rentId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate rentDate;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate returnDate;

    private double rentFee;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rent_id) {
        this.rentId = rent_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rent_date) {
        this.rentDate = rent_date;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate return_date) {
        this.returnDate = return_date;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rent_fee) {
        this.rentFee = rent_fee;
    }

    @Override
    public String toString() {
        return "RentedMovie{" +
                "rentId=" + rentId +
                ", user=" + user +
                ", movie=" + movie +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", rentFee=" + rentFee +
                '}';
    }
}
