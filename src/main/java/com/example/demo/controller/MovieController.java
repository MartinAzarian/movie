package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MovieController {
    private final MovieService movieService;

    @PostMapping(value = "/movie")
    public void creatMovie(@RequestBody Movie movie) {
        movieService.createMovie(movie);
    }

    @DeleteMapping(value = "/movie/{id}")
    public void deleteMoviById(@PathVariable int id) {
        movieService.deleteMovie(id);
    }

    @PutMapping(value = "/movie/{id}")
    public void updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        movieService.updateMovie(id, movie);
    }

    @GetMapping(value = "/movie/find/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable int id) {
        Movie movie = movieService.findMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping(value = "/movie/findall")
    public ResponseEntity<ArrayList<Movie>> findAllMovies() {
        ArrayList<Movie> movieList = movieService.findAllMovies();
        return ResponseEntity.ok(movieList);
    }

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}
