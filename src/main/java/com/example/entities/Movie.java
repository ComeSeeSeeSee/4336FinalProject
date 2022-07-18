package com.example.entities;




import javax.persistence.*;


@Entity
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String timePeriod;


    public Movie() {

    }

    public Movie(Integer id, String name, String description, String timePeriod) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timePeriod = timePeriod;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }
}
