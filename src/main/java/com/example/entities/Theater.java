package com.example.entities;



import javax.persistence.*;
import java.util.List;


@Entity
public class Theater {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    private String theaterName;

    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name = "theater_id_fk")
    private List<Movie> movie;


    public Theater() {
    }

    public Theater(Integer id, String theaterName) {
        this.id = id;
        this.theaterName = theaterName;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", theaterName='" + theaterName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}
