package com.example.demo3.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo3.domain.Movie;
import com.example.demo3.repository.mybatis.MovieMapper;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
	private final SqlSessionTemplate sqlSessionTemplate;
	
	public MovieRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<Movie> findList(String movieName, String directorName){
		List<Movie> movie = this.sqlSessionTemplate.getMapper(MovieMapper.class).find(movieName, directorName);
		return movie;
	}
	
	@Override
	public Movie findOne(String movieId){
		Movie movie = this.sqlSessionTemplate.getMapper(MovieMapper.class).get(movieId);
		if (movie == null){
			throw new RuntimeException("movie not fpund");
		}
		return movie;
	}
	
	@Override
	public Movie lock(String movieId) {
		Movie movie = this.sqlSessionTemplate.getMapper(MovieMapper.class).lock(movieId);
		if (movie == null){
			throw new RuntimeException("movie not found");
		}
		return movie;
	}
	
	@Override
	public void insert(Movie movie) {
		this.sqlSessionTemplate.getMapper(MovieMapper.class).add(movie);
	}
	
	@Override
	public void update(Movie movie) {
		int affected = this.sqlSessionTemplate.getMapper(MovieMapper.class).set(movie);
		if (affected != 1){
			throw new RuntimeException("failed");
		}
	}
	
	@Override
	public void delete(Movie movie) {
		int affected = this.sqlSessionTemplate.getMapper(MovieMapper.class).remove(movie);
		if (affected != 1){
			throw new RuntimeException("failed");
		}
	}
}
