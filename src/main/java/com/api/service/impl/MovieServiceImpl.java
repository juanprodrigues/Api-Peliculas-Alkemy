package com.api.service.impl;

import com.api.dto.MovieBasicDTO;
import com.api.dto.MovieDTO;
import com.api.dto.MovieFiltersDTO;
import com.api.entity.Movie;
import com.api.entity.Character;
import com.api.exception.ParamNotFound;
import com.api.mapper.MovieMapper;
import com.api.repository.MovieRepository;
import com.api.repository.specifications.MovieSpecification;
import com.api.service.CharacterService;
import com.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    // Repo
    private MovieRepository movieRepository;
    private MovieSpecification movieSpecification;
    // Mapper
    private MovieMapper movieMapper;
    // Services
    private CharacterService characterService;

    @Autowired
    public MovieServiceImpl(
            MovieRepository movieRepository,
            MovieSpecification movieSpecification,
            CharacterService characterService,
            MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieSpecification = movieSpecification;
        this.movieMapper = movieMapper;
        this.characterService = characterService;
    }

    public MovieDTO getDetailsById(Long id) {
        Optional<Movie> entity = this.movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id movieo no valido");
        }
        MovieDTO movieDTO = this.movieMapper.movieEntity2DTO(entity.get());
        return movieDTO;
    }

    public List<MovieBasicDTO> getAll() {
        List<Movie> entities = this.movieRepository.findAll();
        List<MovieBasicDTO> movieBasicDTOS = this.movieMapper.movieEntitySet2BasicDTOList(entities);
        return movieBasicDTOS;
    }

    public List<MovieDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(name, date, cities, order);
        List<Movie> entities = this.movieRepository.findAll(
                this.movieSpecification.getByFilters(filtersDTO)
        );
        List<MovieDTO> dtos = this.movieMapper.movieEntitySet2DTOList(entities);
        return dtos;
    }

    public MovieDTO save(MovieDTO movieDTO) {
        Movie entity = this.movieMapper.movieDTO2Entity(movieDTO);
        Movie entitySaved = this.movieRepository.save(entity);
        MovieDTO result = this.movieMapper.movieEntity2DTO(entitySaved);
        return result;
    }

    public MovieDTO update(Long id, MovieDTO movieDTO) {
        Optional<Movie> entity = this.movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id movieo no valido");
        }
        this.movieMapper.movieEntityRefreshValues(entity.get(), movieDTO);
        Movie entitySaved = this.movieRepository.save(entity.get());
        MovieDTO result = this.movieMapper.movieEntity2DTO(entitySaved);
        return result;
    }

    public void addCharacter(Long id, Long idCharacter) {
        Movie entity = this.movieRepository.getById(id);
        entity.getCharacters().size();
        Character characerEntity = this.characterService.getEntityById(idCharacter);
        entity.addPais(characerEntity);
        this.movieRepository.save(entity);
    }

    public void removeCharacter(Long id, Long idCharacter) {
        Movie entity = this.movieRepository.getById(id);
        entity.getCharacters().size();
        Character characerEntity = this.characterService.getEntityById(idCharacter);
        entity.removePais(characerEntity);
        this.movieRepository.save(entity);
    }

    public void delete(Long id) {
        this.movieRepository.deleteById(id);
    }

}
