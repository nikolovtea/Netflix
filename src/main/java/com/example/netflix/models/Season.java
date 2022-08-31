package com.example.netflix.models;

import com.example.netflix.utils.SeasonDTO;
import com.example.netflix.utils.SeriesDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer seasonNumber;

    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Episode> episodes;

    public Season(){}
    public Season(Integer seasonNumber, List<Episode> episodes) {
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
    }
    public static Season from(SeasonDTO seasonDTO){
        Season season=new Season();
        season.seasonNumber=seasonDTO.seasonNumber;
        season.episodes=new ArrayList<>();
        return season;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }


}
