/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mapper;
import com.api.builder.GenderBuilder;
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
        //ContienenteEntity entity = new ContienenteEntity();
        //entity.setImagen(dto.getImagen());
        //entity.setDenominacion(dto.getDenominacion());
        //return entity;

        Gender entity = new GenderBuilder()
                .imagen(dto.getImagen())
                .nombre(dto.getNombre())
                .build();

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


}
