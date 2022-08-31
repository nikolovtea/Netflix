package com.example.netflix.models;

import com.example.netflix.utils.EpisodeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String watched;
    @Column
    private String dateWatched;
    @JsonIgnore
    @OneToOne
    private Series series;
    @JsonIgnore
    @OneToOne
    private Season season;

    public Episode(){}

    public Episode(String name, String watched, Series series,Season season) {
        this.name = name;
        this.watched = watched;
        this.series = series;
        this.season=season;
    }
    public static Episode from(EpisodeDTO episodeDTO){
        Episode ep=new Episode();
        ep.name=episodeDTO.name;
        ep.watched=episodeDTO.watched;
        return ep;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

}
