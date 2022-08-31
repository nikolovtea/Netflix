package com.example.netflix.controllers;

import com.example.netflix.models.Episode;
import com.example.netflix.services.EpisodeService;
import com.example.netflix.services.SeriesService;
import com.example.netflix.utils.EpisodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("episode")
@CrossOrigin("*")
public class EpisodeController {
    @Autowired
    SeriesService seriesService;
    @Autowired
    EpisodeService episodeService;

    @GetMapping("/{id}")
    ResponseEntity<Episode> getEpisodeById(@PathVariable Long id) {
        return ResponseEntity.ok(episodeService.getEpisodeById(id));
    }
    @PostMapping
    ResponseEntity<Episode> addEpisode(@RequestBody EpisodeDTO episodeDTO){
        return ResponseEntity.ok(episodeService.createEpisode(episodeDTO));
    }

    @PutMapping("/{episodeId}")
    ResponseEntity<Episode> updateEpisodeStatus(@PathVariable Long episodeId, @RequestParam("watched") String watched, @RequestParam("dateWatched") String dateWatched) {
        return ResponseEntity.ok(episodeService.updateEpisodeStatus(episodeId, watched,dateWatched));
    }

}
