/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mapper;

import com.api.dto.GenderDTO;
import com.api.entity.Gender;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 * @author JuanPC
 */

@Component
public class GenderMapper {
	public Gender genderDTO2Entity(GenderDTO dto) {
		Gender entity = new Gender();
		entity.setIdGender(dto.getId());
		entity.setImage(dto.getImagen());
		entity.setName(dto.getNombre());
		return entity;
	}

	public GenderDTO genderEntity2DTO(Gender entity) {
		GenderDTO dto = new GenderDTO();
		dto.setId(entity.getIdGender());
		dto.setImagen(entity.getImage());
		dto.setNombre(entity.getName());
		return dto;
	}

	public List<GenderDTO> genderEntityList2DTOList(List<Gender> entities) {
		List<GenderDTO> dtos = new ArrayList<>();
		for (Gender entity : entities) {
			dtos.add(this.genderEntity2DTO(entity));
		}
		return dtos;
	}

	public List<Gender> DTOList2genderEntityList(List<GenderDTO> entities) {
		List<Gender> entity = new ArrayList<>();
		for (GenderDTO dtos : entities) {
			entity.add(this.genderDTO2Entity(dtos));
		}
		return entity;
	}
	
	public void genderEntityRefreshValues(Gender gender, GenderDTO genderDTO) {
		gender.setImage(genderDTO.getImagen());
		gender.setName(genderDTO.getNombre());
	}


}
