package com.example.netflix.models;

import com.example.netflix.utils.SeriesDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double rating;
    @Column
    private  String imageUrl;
    @JsonIgnore
    @OneToOne
    UserModel creator;
    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Episode> episodes;
    public Series(){}

    public Series(String name, String description, Double rating, String imageUrl, UserModel creator, List<Episode> episodes) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.creator = creator;
        this.episodes = episodes;
    }

    public static Series from(SeriesDTO seriesDTO){
        Series sr=new Series();
        sr.name=seriesDTO.name;
        sr.description=seriesDTO.description;
        sr.rating=seriesDTO.rating;
        sr.imageUrl=seriesDTO.imageUrl;
        sr.episodes=new ArrayList<>();
        return sr;
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

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
