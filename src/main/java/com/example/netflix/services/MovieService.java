package com.example.netflix.services;


import com.example.netflix.models.Movie;
import com.example.netflix.models.UserModel;
import com.example.netflix.repos.MovieRepository;
import com.example.netflix.repos.UserRepository;
import com.example.netflix.utils.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

    public Movie createMovie(MovieDTO movieDTO) {
        UserModel userModel = userService.findByUsername(movieDTO.creatorUsername);
        Movie mv = Movie.from(movieDTO);
        mv.setCreator(userModel);
        Movie savedMovie = movieRepository.save(mv);
        userModel.getCreatedMovies().add(savedMovie);
        userRepository.save(userModel);
        return savedMovie;
    }
    public Movie updateMovieStatus(Long movieId, String watched, String dateWatched) {
        Movie mv = movieRepository.findById(movieId).orElseThrow();
        mv.setWatched(watched);
        mv.setDateWatched(dateWatched);
        return movieRepository.save(mv);
    }

    public String delete(MovieDTO movieDTO) throws Exception{
        movieRepository.deleteMovieByName(movieDTO.name);
            return "Movie deleted successfully!";
        }

}
