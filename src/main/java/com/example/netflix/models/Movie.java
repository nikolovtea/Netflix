package com.example.netflix.models;

import com.example.netflix.utils.MovieDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column
    private String description;
    @Column
    private Double rating;
    @Column
    private String watched;
    @Column
    private String dateWatched;
    @Column
    private String imageUrl;
    @JsonIgnore
    @OneToOne
    UserModel creator;
    public Movie() {
    }

    public Movie(Long id, String name, String description, Double rating, String watched, String dateWatched, String imageUrl, UserModel creator) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.watched = watched;
        this.dateWatched = dateWatched;
        this.imageUrl = imageUrl;
        this.creator = creator;
    }

    public static Movie from(MovieDTO movieDTO){
        Movie mv=new Movie();
        mv.name=movieDTO.name;
        mv.description=movieDTO.description;
        mv.watched= movieDTO.watched;
        mv.rating=movieDTO.rating;
        mv.imageUrl=movieDTO.imageUrl;
        return mv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getWatched() {
        return watched;
    }

    public void setWatched(String watched) {
        this.watched = watched;
    }

    public String getDateWatched() {
        return dateWatched;
    }

    public void setDateWatched(String dateWatched) {
        this.dateWatched = dateWatched;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserModel getCreator() {
        return creator;
    }

    public void setCreator(UserModel creator) {
        this.creator = creator;
    }
}
