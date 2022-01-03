package com.api.controller;

import com.api.dto.MovieBasicDTO;
import com.api.dto.MovieDTO;
import com.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("movies")
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	// Lista todas las peliculas con atributos basicos
	@GetMapping
	public ResponseEntity<List<MovieBasicDTO>> getBasic() {
		List<MovieBasicDTO> genderDTOList = this.movieService.getAllBasic();
		return ResponseEntity.ok(genderDTOList);
	}

	// Lista todas las peliculas con sus atributos
	@GetMapping("all")
	public ResponseEntity<List<MovieDTO>> getAll() {
		List<MovieDTO> genderDTOList = this.movieService.getAll();
		return ResponseEntity.ok(genderDTOList);
	}

	// Crear una pelicula...
	@PostMapping
	public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO genderDTO) {
		MovieDTO result = this.movieService.save(genderDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	// Modificaria una pelicula
	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
		MovieDTO result = this.movieService.update(id, movieDTO);
		return ResponseEntity.ok().body(result);
	}

	// Eliminar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.movieService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// Buscar pelicula por nombre
	// http://localhost:8080/movies?name=nombre
	// http://localhost:8080/movies?name=Futurama
	@GetMapping(value = "", params = "name")
	public ResponseEntity<List<MovieDTO>> searchCharacterByName(@RequestParam String name) {
		try {
			List<MovieDTO> moviesDTO = movieService.findByName(name);

			if (!moviesDTO.isEmpty()) {
				return new ResponseEntity<>(moviesDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// findByIdGenre
	// http://localhost:8080/movies?gender=id
	// http://localhost:8080/movies?gender=1
	@GetMapping(value = "", params = "gender")
	public ResponseEntity<List<MovieDTO>> findByIdGenre(@RequestParam Integer gender) {
		try {
			List<MovieDTO> moviesDTO = movieService.findByIdGenre(gender);

			if (!moviesDTO.isEmpty()) {
				return new ResponseEntity<>(moviesDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// findByIdGenre
	// http://localhost:8080/movies?order=ASC
	// http://localhost:8080/movies?order=DESC
	@GetMapping(value = "", params = "order")
	public ResponseEntity<List<MovieDTO>> orderByOrder(@RequestParam String order) {
		try {
			List<MovieDTO> moviesDTO = movieService.findByOrder(order);

			if (!moviesDTO.isEmpty()) {
				return new ResponseEntity<>(moviesDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
