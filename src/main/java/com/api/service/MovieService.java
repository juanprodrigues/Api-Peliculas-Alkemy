package com.api.service;

import com.api.dto.MovieBasicDTO;
import com.api.dto.MovieDTO;
import com.api.entity.Movie;

import java.util.List;

public interface MovieService {
	List<MovieDTO> getAll();

	List<MovieBasicDTO> getAllBasic();

	MovieDTO save(MovieDTO movieDTO);

	MovieDTO update(Long id, MovieDTO movieDTO);

	void delete(Long id);

	List<MovieDTO> listMovies2ListMoviesDTO(List<Movie> movies);

	List<MovieDTO> findByName(String name);

	List<MovieDTO> findByIdGenre(Integer idGendero);

	List<MovieDTO> findByOrder(String order);

}
