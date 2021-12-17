/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.service;

import com.api.entity.Character;
import com.api.dto.CharacterDTO;
import com.api.dto.CharacterDTOParameter;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public interface CharacterService {

    List<CharacterDTO> getAllCharacter();

    List<CharacterDTOParameter> getNameImage();

    CharacterDTO save(CharacterDTO paisDTO);

    Character getEntityById(Long id);

    void deleteEntityBy(Long id);

    CharacterDTO modify(CharacterDTO paisDTO, Long id);

    List<CharacterDTO> findByName(String name);

    List<CharacterDTO> findByAge(Integer age);

    List<CharacterDTO> findByIdMovie(Long idMovie);
}
