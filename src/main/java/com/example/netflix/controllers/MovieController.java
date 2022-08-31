package com.example.netflix.controllers;

import com.example.netflix.models.Movie;
import com.example.netflix.services.MovieService;
import com.example.netflix.utils.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/{id}")
    ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @PostMapping
    ResponseEntity<Movie> addMovie(@RequestBody MovieDTO movieDTO) {
        return ResponseEntity.ok(movieService.createMovie(movieDTO));
    }

    @PutMapping("/{id}")
    ResponseEntity<Movie> updateMovieStatus(@PathVariable Long id, @RequestParam("watched") String watched, @RequestParam("dateWatched") String dateWatched) throws Exception {
        return ResponseEntity.ok(movieService.updateMovieStatus(id, watched, dateWatched));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> deleteMovie(@RequestBody MovieDTO movieDTO) throws Exception {
        return ResponseEntity.ok(movieService.delete(movieDTO));
    }


}
