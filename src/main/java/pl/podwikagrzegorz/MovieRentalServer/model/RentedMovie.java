package pl.podwikagrzegorz.MovieRentalServer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RentedMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rentId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate rentDate;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate returnDate;

    private double rentFee;

    private boolean paid;

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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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
                ", isPaid=" + paid +
                '}';
    }
}
