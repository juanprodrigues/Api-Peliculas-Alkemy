package com.api.service.impl;

import com.api.dto.MovieBasicDTO;
import com.api.dto.MovieDTO;
import com.api.entity.Movie;
import com.api.exception.ParamNotFound;
import com.api.mapper.MovieMapper;
import com.api.repository.MovieRepository;
import com.api.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

	// Repo
	private MovieRepository movieRepository;

	// Mapper
	private MovieMapper movieMapper;


	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository,MovieMapper movieMapper) {
		this.movieRepository = movieRepository;
		this.movieMapper = movieMapper;
	}


	// Buscar Pelicula con atributos basicos
	@Override
	public List<MovieBasicDTO> getAllBasic() {
		List<Movie> entities = this.movieRepository.findAll();
		List<MovieBasicDTO> movieBasicDTOS = this.movieMapper.movieEntitySet2BasicDTOList(entities);
		return movieBasicDTOS;
	}

	// Buscar Peliculas con todos sus atributos
	@Override
	public List<MovieDTO> getAll() {
		List<Movie> entities = this.movieRepository.findAll();
		List<MovieDTO> movieBasicDTOS = this.movieMapper.movieEntitySet2DTOList(entities, true);
		return movieBasicDTOS;
	}


	// guardad peli
	@Override
	public MovieDTO save(MovieDTO movieDTO) {
		Movie entity = this.movieMapper.movieDTO2Entity(movieDTO);
		Movie entitySaved = this.movieRepository.save(entity);
		MovieDTO result = this.movieMapper.movieEntity2DTO(entitySaved, true);
		return result;
	}
	@Override
	public MovieDTO update(Long id, MovieDTO movieDTO) {
		Optional<Movie> entity = this.movieRepository.findById(id);
		if (!entity.isPresent()) {
			throw new ParamNotFound("Id movieo no valido");
		}
		// (entidad buscada, movieDTO entrante)
		// Mapea la entidad ingresada con la pelicula busca por id
		this.movieMapper.movieEntityRefreshValues(entity.get(), movieDTO);

		Movie entitySaved = this.movieRepository.save(entity.get());
		MovieDTO result = this.movieMapper.movieEntity2DTO(entitySaved, false);
		return result;
	}

	@Override
	public void delete(Long id) {
		this.movieRepository.deleteById(id);
	}
	@Override
	public List<MovieDTO> listMovies2ListMoviesDTO(List<Movie> movies) {
		List<MovieDTO> moviesDTO = new ArrayList<>();

		for (Movie movie : movies) {
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setId(movie.getIdMovie());
			movieDTO.setImagen(movie.getImage());
			movieDTO.setTitulo(movie.getTitle());
			movieDTO.setFechaCreacion(movieMapper.LocalDate2String(movie.getCreatedDate()));
			movieDTO.setCalificacion(movie.getQualification());
			movieDTO.setIdGenero(movie.getIdGender());
			// movieDTO.setCharacters(movie.getCharacters());
			moviesDTO.add(movieDTO);
		}
		return moviesDTO;
	}

	@Override
	public List<MovieDTO> findByName(String name) {

		List<Movie> movies = movieRepository.findByTitle(name);

		return listMovies2ListMoviesDTO(movies);
	}

	@Override
	public List<MovieDTO> findByIdGenre(Integer idGendero) {

		List<Movie> movies = movieRepository.findByIdGender(idGendero);

		return listMovies2ListMoviesDTO(movies);
	}

	@Override
	public List<MovieDTO> findByOrder(String order) {
		List<Movie> movies = null;
		if (order.equals("ASC")) {
			movies = movieRepository.OrdendadoASC();
		} else {
			movies = movieRepository.OrdendadoDESC();
		}

		return listMovies2ListMoviesDTO(movies);
	}

}
