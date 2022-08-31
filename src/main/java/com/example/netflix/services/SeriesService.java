package com.example.netflix.services;

import com.example.netflix.models.*;
import com.example.netflix.repos.EpisodeRepository;
import com.example.netflix.repos.SeriesRepository;
import com.example.netflix.repos.UserRepository;
import com.example.netflix.utils.EpisodeDTO;
import com.example.netflix.utils.SeriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    UserService userService;

    public Series getSeriesById(Long id) {
        return seriesRepository.findById(id).get();
    }

    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    public Series createSeries(SeriesDTO seriesDTO) {
        UserModel userModel = userService.findByUsername(seriesDTO.creatorUsername);
        Series sr = Series.from(seriesDTO);
        sr.setCreator(userModel);
        Series savedSeries = seriesRepository.save(sr);
        userModel.getCreatedSeries().add(savedSeries);
        userRepository.save(userModel);
        return savedSeries;
    }

    public Series findByName(String name) {

        return seriesRepository.findSeriesByName(name).orElseThrow();
    }

    public Episode getSeriesLastEpisode(Long seriesId) {
        Series series=seriesRepository.findById(seriesId).get();
        Integer size=series.getEpisodes().size();
        return series.getEpisodes().get(size-1);

    }
}
