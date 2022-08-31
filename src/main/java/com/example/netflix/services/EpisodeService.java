package com.example.netflix.services;

import com.example.netflix.models.*;
import com.example.netflix.repos.EpisodeRepository;
import com.example.netflix.repos.SeasonRepository;
import com.example.netflix.repos.SeriesRepository;
import com.example.netflix.utils.EpisodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EpisodeService {
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    SeriesService seriesService;
    @Autowired
    SeasonService seasonService;

    public Episode getEpisodeById(Long id) {
        return episodeRepository.findById(id).get();
    }

    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    public Episode createEpisode(EpisodeDTO episodeDTO) {
        Series series = seriesService.findByName(episodeDTO.seriesName);
        Season season=seasonService.findByNumber(episodeDTO.seasonNumber);
        Episode ep = Episode.from(episodeDTO);
        ep.setSeries(series);
        ep.setSeason(season);
        Episode savedEpisode = episodeRepository.save(ep);
        series.getEpisodes().add(savedEpisode);
        season.getEpisodes().add(savedEpisode);
        seriesRepository.save(series);
        seasonRepository.save(season);
        return savedEpisode;
    }
    public Episode updateEpisodeStatus(Long episodeId, String watched, String dateWatched) {
        Episode ep = episodeRepository.findById(episodeId).orElseThrow();
        ep.setWatched(watched);
        ep.setDateWatched(dateWatched);
        return episodeRepository.save(ep);
    }
}

