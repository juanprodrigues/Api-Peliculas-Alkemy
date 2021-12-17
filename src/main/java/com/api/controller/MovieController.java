package com.api.controller;


import com.api.dto.MovieBasicDTO;
import com.api.dto.MovieDTO;
import com.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAll() {
        List<MovieBasicDTO> genderDTOList = this.movieService.getAll();
        return ResponseEntity.ok(genderDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getDetailsById(@PathVariable Long id) {
        MovieDTO movieDTO = this.movieService.getDetailsById(id);
        return ResponseEntity.ok(movieDTO);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MovieDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Set<Long> cities,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<MovieDTO> movieDTO = this.movieService.getByFilters(name, date, cities, order);
        return ResponseEntity.ok(movieDTO);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO genderDTO) {
        MovieDTO result = this.movieService.save(genderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        MovieDTO result = this.movieService.update(id, movieDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/movie/{idCharacter}")
    public ResponseEntity<Void> addCharacter(@PathVariable Long id, @PathVariable Long idCharacter) {
        this.movieService.addCharacter(id, idCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/movie/{idCharacter}")
    public ResponseEntity<Void> removeCharacter(@PathVariable Long id, @PathVariable Long idCharacter) {
        this.movieService.removeCharacter(id, idCharacter);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
