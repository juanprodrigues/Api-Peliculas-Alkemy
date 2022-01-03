/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mapper;

import com.api.dto.CharacterDTO;
import com.api.dto.MovieBasicDTO;
import com.api.dto.MovieDTO;
import com.api.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
 *
 * @author JuanPC
 */
@Component
public class MovieMapper {

	@Autowired
	private CharacterMapper characterMapper;

	public Movie movieDTO2Entity(MovieDTO dto) {
		Movie entity = new Movie();
		entity.setIdMovie(dto.getId());
		entity.setImage(dto.getImagen());
		entity.setTitle(dto.getTitulo());
		entity.setCreatedDate(this.string2LocalDate(dto.getFechaCreacion()));
		entity.setQualification(dto.getCalificacion());
		entity.setIdGender(dto.getIdGenero());
		return entity;
	}

	public MovieDTO movieEntity2DTO(Movie entity, Boolean boolean1) {
		MovieDTO dto = new MovieDTO();
		dto.setId(entity.getIdMovie());
		dto.setImagen(entity.getImage());
		dto.setTitulo(entity.getTitle());
		dto.setFechaCreacion(entity.getCreatedDate().toString());
		dto.setCalificacion(entity.getQualification());
		dto.setIdGenero(entity.getIdGender());
		//System.out.println("estoy en el mapper de movie");
		if (boolean1) {
			List<CharacterDTO> characterDTO = this.characterMapper.characterEntityList2DTOList(entity.getCharacters());
			dto.setCharacters(characterDTO);
		}

		return dto;
	}

	public LocalDate string2LocalDate(String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}

	public String LocalDate2String(LocalDate localDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String output = dtf.format(localDate);
		return output;
	}

	public void movieEntityRefreshValues(Movie entity, MovieDTO movieDTO) {
		entity.setImage(movieDTO.getImagen());
		entity.setTitle(movieDTO.getTitulo());
		entity.setCreatedDate(this.string2LocalDate(movieDTO.getFechaCreacion()));
		entity.setQualification(movieDTO.getCalificacion());
		entity.setIdGender(movieDTO.getIdGenero());
	}

	public Set<Movie> movieDTOList2Entity(List<MovieDTO> dtos) {
		Set<Movie> entities = new HashSet<>();
		for (MovieDTO dto : dtos) {
			entities.add(this.movieDTO2Entity(dto));
		}
		return entities;
	}

	public List<MovieDTO> movieEntitySet2DTOList(Collection<Movie> entities, Boolean boolean1) {
		List<MovieDTO> dtos = new ArrayList<>();
		for (Movie entity : entities) {
			dtos.add(this.movieEntity2DTO(entity, boolean1));
		}
		return dtos;
	}

	public List<MovieBasicDTO> movieEntitySet2BasicDTOList(List<Movie> entities) {
		List<MovieBasicDTO> dtos = new ArrayList<>();
		MovieBasicDTO basicDTO;
		for (Movie entity : entities) {
			basicDTO = new MovieBasicDTO();

			basicDTO.setImagen(entity.getImage());
			basicDTO.setTitulo(entity.getTitle());
			basicDTO.setFechaCreacion(LocalDate2String(entity.getCreatedDate()));
			
			dtos.add(basicDTO);
		}
		return dtos;
	}

}
