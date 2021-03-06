/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.controller;

import com.api.dto.GenderDTO;
import com.api.service.GenderService;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JuanPC
 */
@RestController
@RequestMapping("gender")
public class GenderController {

    
    private GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public ResponseEntity<List<GenderDTO>> getAll() {
        List<GenderDTO> gender = this.genderService.getAllContinentes();
        return ResponseEntity.ok().body(gender);
    }

    @PostMapping
    public ResponseEntity<GenderDTO> save(@RequestBody GenderDTO continente) {
        GenderDTO result = this.genderService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    

	// Modificaria una pelicula
	@PutMapping("/{id}")
	public ResponseEntity<GenderDTO> update(@PathVariable Long id, @RequestBody GenderDTO movieDTO) {
		GenderDTO result = this.genderService.update(id, movieDTO);
		return ResponseEntity.ok().body(result);
	}

	// Eliminar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.genderService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}