package com.example.demo3.service;

import com.example.demo3.domain.Movie;
import com.example.demo3.domain.MovieList;

public interface MovieService {
	
	MovieList find(String movieName, String directorName);
	
	Movie get(String movieId);
	
	void add(Movie movie);
	
	void set(Movie movie);
	
	void remove(String movieId);

}
