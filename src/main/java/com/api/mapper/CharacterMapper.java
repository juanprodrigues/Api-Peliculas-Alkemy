/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mapper;

import com.api.dto.CharacterDTO;
import com.api.dto.CharacterDTOParameter;
import com.api.dto.MovieDTO;
import com.api.entity.Character;
import com.api.entity.Movie;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author JuanPC
 */
@Component
public class CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;

    public Character CharacterDTO2Entity(CharacterDTO dto) {
        Character entity = new Character();
        entity.setIdCharacter(dto.getId_character());
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
        // mapea todo menos la pelicula
        entity.setIdMovie(dto.getId_movie());
        Set<Movie> movies = this.movieMapper.movieDTOList2Entity(dto.getMovies());
        entity.setMovies(movies);
        return entity;
    }

    public CharacterDTO Entity2CharacterDTO(Character entity) {
        CharacterDTO dto = new CharacterDTO();

        dto.setId_character(entity.getIdCharacter());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());

        dto.setId_movie(entity.getIdMovie());

        List<MovieDTO> movieDTOS = this.movieMapper.movieEntitySet2DTOList((List<Movie>) entity.getMovies());
        dto.setMovies(movieDTOS);

        return dto;
    }

    public CharacterDTOParameter Entity2CharacterDTONameImagen(Character entity) {
        CharacterDTOParameter dto = new CharacterDTOParameter();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }

    public List<CharacterDTOParameter> EntityList2DTOListNameImagen(List<Character> entities) {
        List<CharacterDTOParameter> dtos = new ArrayList<>();
        for (Character entity : entities) {
            dtos.add(Entity2CharacterDTONameImagen(entity));
        }
        return dtos;
    }

    public List<CharacterDTO> EntityList2DTOList(List<Character> entities) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for (Character entity : entities) {
            dtos.add(Entity2CharacterDTO(entity));
        }
        return dtos;
    }

    public List<Character> DTOList2EntityList(List<CharacterDTO> dtos) {
        List<Character> entities = new ArrayList<>();
        for (CharacterDTO dto : dtos) {
            entities.add(this.CharacterDTO2Entity(dto));
        }
        return entities;
    }

    public List<CharacterDTO> paisEntityList2DTOList(List<Character> entities) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for (Character entity : entities) {
            dtos.add(this.Entity2CharacterDTO(entity));
        }
        return dtos;
    }
}
