/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.service.impl;

import com.api.dto.GenderDTO;
import com.api.entity.Gender;
import com.api.exception.ParamNotFound;
import com.api.mapper.GenderMapper;
import com.api.repository.GenderRepository;
import com.api.service.GenderService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanPC
 */
@Service
public class GenderServiceImpl implements GenderService  {
     private GenderRepository genderRepository;
    private GenderMapper genderMapper;

    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository, GenderMapper genderMapper) {
        this.genderRepository = genderRepository;
        this.genderMapper = genderMapper;
    }

    public List<GenderDTO> getAllContinentes() {
        List<Gender> entities = this.genderRepository.findAll();
        List<GenderDTO> result = this.genderMapper.genderEntityList2DTOList(entities);
        return result;
    }

    public GenderDTO save(GenderDTO gender) {
        Gender contienenteEntity = this.genderMapper.genderDTO2Entity(gender);
        
        Gender entitySaved = this.genderRepository.save(contienenteEntity);
        GenderDTO result = this.genderMapper.genderEntity2DTO(entitySaved);
        return result;
    }
    
	@Override
	public GenderDTO update(Long id, GenderDTO genderDTO) {
		Optional<Gender> entity = this.genderRepository.findById(id);
		if (!entity.isPresent()) {
			throw new ParamNotFound("Id gender no valido");
		}
		// (entidad buscada, genderDTO entrante)
		// Mapea la entidad ingresada con la genero busca por id
		this.genderMapper.genderEntityRefreshValues(entity.get(), genderDTO);

		Gender entitySaved = this.genderRepository.save(entity.get());
		GenderDTO result = this.genderMapper.genderEntity2DTO(entitySaved);
		return result;
	}

	@Override
	public void delete(Long id) {
		this.genderRepository.deleteById(id);
	}
    
}
