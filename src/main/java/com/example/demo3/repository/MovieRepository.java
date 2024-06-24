package com.example.demo3.repository;

import java.util.List;

import com.example.demo3.domain.Movie;

public interface MovieRepository {
	
	List<Movie> findList(String movieName, String directorName);
	
	Movie findOne(String movieId);
	
	Movie lock(String movieId);
	
	void insert(Movie movie);
	
	void update(Movie movie);
	
	void delete(Movie movie);
	

}
