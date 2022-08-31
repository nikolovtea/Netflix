package com.example.netflix.controllers;

import com.example.netflix.models.Episode;
import com.example.netflix.models.Series;
import com.example.netflix.services.SeriesService;
import com.example.netflix.utils.SeriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("series")
@CrossOrigin("*")
public class SeriesController {
    @Autowired
    SeriesService seriesService;

    @GetMapping("/{id}")
    ResponseEntity<Series> getSeriesById(@PathVariable Long id) {
        return ResponseEntity.ok(seriesService.getSeriesById(id));
    }

    @GetMapping
    ResponseEntity<List<Series>> getAllSeries() {
        return ResponseEntity.ok(seriesService.getAllSeries());
    }

    @PostMapping
    ResponseEntity<Series> addSeries(@RequestBody SeriesDTO seriesDTO) {
        return ResponseEntity.ok(seriesService.createSeries(seriesDTO));
    }

    @GetMapping("/{seriesId}/lastEpisode")
    ResponseEntity<Episode> getSeriesLastEpisode(@PathVariable Long seriesId) {
        return ResponseEntity.ok(seriesService.getSeriesLastEpisode(seriesId));
    }

}
