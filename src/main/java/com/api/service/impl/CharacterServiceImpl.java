/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.service.impl;

import com.api.dto.CharacterDTO;
import com.api.dto.CharacterDTOParameter;
import com.api.entity.Character;
import com.api.mapper.CharacterMapper;
import com.api.repository.CharacterRepository;
import com.api.service.CharacterService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanPC
 */
@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository characterRepository;
	@Autowired
	private CharacterMapper characterMapper;

	@Autowired
	public CharacterServiceImpl(CharacterRepository characterRepository, CharacterMapper CharacterMapper) {
		this.characterRepository = characterRepository;
		this.characterMapper = CharacterMapper;
	}

	// listar todos los atribulos de un personaje
	@Override
	public List<CharacterDTO> getAllCharacter(Boolean boolean1) {
		List<Character> entities = this.characterRepository.findAll();
		List<CharacterDTO> dtos = this.characterMapper.EntityList2DTOList(entities,boolean1);
		return dtos;
	}
	// listar todos el atributo de nombre y imagen de un personaje

	@Override
	public List<CharacterDTOParameter> getNameImage() {
		List<Character> entities = this.characterRepository.findAll();
		List<CharacterDTOParameter> dtos = this.characterMapper.EntityList2DTOListNameImagen(entities);
		return dtos;
	}

	// Guardar un personaje
	@Override
	public CharacterDTO save(CharacterDTO paisDTO) {
		Character characterEntity = null;
		Character entitySaved = null;
		System.out.println("CharacterDTO entrante" + paisDTO.toString());

		characterEntity = this.characterMapper.CharacterDTO2Entity(paisDTO);
		System.out.println("characterEntity guardad en la base de datos" + characterEntity.toString());

		try {
			// guarda en la bd

			entitySaved = this.characterRepository.save(characterEntity);
			System.out.println("Entidad guardad en la base de datos" + entitySaved.toString());

		} catch (Exception e) {
			System.out.println("error en entitySaved: "+e.toString());
		}
		try {
			CharacterDTO result = this.characterMapper.Entity2CharacterDTO(entitySaved,true);
			return result;
		} catch (Exception e) {
			return null;
		}

		
	}

	// Servicio para buscar personaje por id
	@Override
	public Character getEntityById(Long id) {
		return this.characterRepository.findById(id).get();
	}

	// Servicio para eliminar personaje por id
	@Override
	public void deleteEntityBy(Long id) {
		this.characterRepository.deleteById(id);
	}

	// Modificar un personaje
	@Override
	public CharacterDTO modify(CharacterDTO paisDTO, Long id) {

		Character characterEntity = this.characterMapper.CharacterDTO2Entity(paisDTO);

		Character personajeUpdate = getEntityById(id);

		personajeUpdate.setImage(characterEntity.getImage());
		personajeUpdate.setName(characterEntity.getName());
		personajeUpdate.setAge(characterEntity.getAge());
		personajeUpdate.setWeight(characterEntity.getWeight());
		personajeUpdate.setHistory(characterEntity.getHistory());

		Character entitySaved = this.characterRepository.save(personajeUpdate);

		CharacterDTO result = this.characterMapper.Entity2CharacterDTO(entitySaved,true);
		return result;
	}

	@Override
	public List<CharacterDTO> findByName(String name) {
		List<Character> characters = characterRepository.findByName(name);
		List<CharacterDTO> charactersDTO = new ArrayList<>();

		for (Character character : characters) {
			CharacterDTO characterDTO = new CharacterDTO();
			characterDTO.setId_character(character.getIdCharacter());
			characterDTO.setImage(character.getImage());
			characterDTO.setName(character.getName());
			characterDTO.setAge(character.getAge());
			characterDTO.setWeight(character.getWeight());
			characterDTO.setHistory(character.getHistory());

			charactersDTO.add(characterDTO);
		}

		return charactersDTO;
	}

	@Override
	public List<CharacterDTO> findByAge(Integer age) {
		List<Character> characters = characterRepository.findByAge(age);

		List<CharacterDTO> charactersDTO = new ArrayList<>();

		for (Character character : characters) {
			CharacterDTO characterDTO = new CharacterDTO();
			characterDTO.setId_character(character.getIdCharacter());
			characterDTO.setImage(character.getImage());
			characterDTO.setName(character.getName());
			characterDTO.setAge(character.getAge());
			characterDTO.setWeight(character.getWeight());
			characterDTO.setHistory(character.getHistory());
			characterDTO.setId_movie(character.getIdMovie());
			charactersDTO.add(characterDTO);
		}

		return charactersDTO;
	}

	@Override
	public List<CharacterDTO> findByIdMovie(Long idMovie) {
		List<Character> characters = characterRepository.findByIdMovie(idMovie);
		List<CharacterDTO> charactersDTO = new ArrayList<>();

		for (Character character : characters) {
			CharacterDTO characterDTO = new CharacterDTO();
			characterDTO.setId_character(character.getIdCharacter());
			characterDTO.setImage(character.getImage());
			characterDTO.setName(character.getName());
			characterDTO.setAge(character.getAge());
			characterDTO.setWeight(character.getWeight());
			characterDTO.setHistory(character.getHistory());
			characterDTO.setId_movie(character.getIdMovie());
			charactersDTO.add(characterDTO);
		}
		return charactersDTO;
	}

}
