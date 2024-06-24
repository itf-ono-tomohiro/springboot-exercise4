package com.example.demo3.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.domain.Movie;
import com.example.demo3.domain.MovieList;
import com.example.demo3.service.MovieService;

@RestController
@RequestMapping("api/movie")
public class MovieRestController {
	
	private final MovieService service;
	
	public MovieRestController(MovieService service){
		this.service = service; 
	}
	
	@GetMapping(path="", produces = "application/json")
	public MovieList find(@RequestParam(name = "movieName", required = false) String movieName,
			@RequestParam(name = "directorName", required = false) String directorName){
		return this.service.find(movieName,  directorName);
	}
	
	@GetMapping(path="/{movieId}", produces = "application/json")
	public Movie get(@PathVariable String movieId) {
		return this.service.get(movieId);
	}
	
	@PostMapping(path="", produces = "application/json")
	public void add(@RequestBody Movie movie) {
		this.service.add(movie);
	}
	
	@PatchMapping(path="/{movieId}", produces = "application/json")
	public void get(@PathVariable String movieId,@RequestBody Movie movie) {
		movie.setMovieId(movieId);
		this.service.set(movie);
	}
	
	@DeleteMapping(path="/{movieId}", produces = "application/json")
	public void remove(@PathVariable String movieId) {
		this.service.remove(movieId);
	}

}
