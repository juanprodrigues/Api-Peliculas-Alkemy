/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.service;

import com.api.dto.GenderDTO;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public interface GenderService {

	List<GenderDTO> getAllContinentes();

	GenderDTO save(GenderDTO continente);

	void delete(Long id);

	GenderDTO update(Long id, GenderDTO movieDTO);
}
