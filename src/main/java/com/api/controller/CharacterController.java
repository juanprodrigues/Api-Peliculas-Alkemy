/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.controller;

/**
 *
 * @author JuanPC
 */
import com.api.dto.CharacterDTO;
import com.api.entity.Character;
import com.api.dto.CharacterDTOParameter;
import com.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("character")
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    //endpoints
    
    //Traer todos los personales
    @GetMapping("/all")
    public ResponseEntity<List<CharacterDTO>> getAll() {
        List<CharacterDTO> personajes = this.characterService.getAllCharacter(false);
        return ResponseEntity.ok().body(personajes);
    }

    // Traer todos los personajes , con el atributo de nombre y imagen
    @GetMapping
    public ResponseEntity<List<CharacterDTOParameter>> getNameImage() {
        List<CharacterDTOParameter> personajes = this.characterService.getNameImage();
        return ResponseEntity.ok().body(personajes);
    }

    // Guarda un personaje, enviar como Body un DTO
    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO personajes) {
        CharacterDTO personajesDTO = this.characterService.save(personajes);
        return ResponseEntity.ok().body(personajesDTO);
    }

    ///Busca un personaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable(name = "id") Long id) {
        Character personajes = this.characterService.getEntityById(id);
        return ResponseEntity.ok().body(personajes);
    }

    ///Elimina un personaje por ID
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Character> delete(@PathVariable(name = "id") long id) {

        this.characterService.deleteEntityBy(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //Modifica un personaje por ID
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CharacterDTO> modify(@RequestBody CharacterDTO personaje, @PathVariable Long id) {

        CharacterDTO personajesDTO = characterService.modify(personaje, id);

        return ResponseEntity.ok().body(personajesDTO);

    }

    //Buscar personajes por nombre
    //http://localhost:8080/character?name=nombre
    //http://localhost:8080/character?name=lisa
    @GetMapping(value = "", params = "name")
    public ResponseEntity<List<CharacterDTO>> searchCharacterByName(@RequestParam String name) {
        try {
            List<CharacterDTO> charactersDTO = characterService.findByName(name);

            if (!charactersDTO.isEmpty()) {
                return new ResponseEntity<>(charactersDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Buscar personajes por edad
    //http://localhost:8080/character?age=age
    //http://localhost:8080/character?age=10
    @GetMapping(value = "", params = "age")
    public ResponseEntity<List<CharacterDTO>> searchCharacterByAge(@RequestParam Integer age) {
        try {
            List<CharacterDTO> charactersDTO = characterService.findByAge(age);

            if (!charactersDTO.isEmpty()) {
                return new ResponseEntity<>(charactersDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Buscar personajes por Id Movie
    //http://localhost:8080/character?name=idMOvie
    //http://localhost:8080/character?movies=1
    @GetMapping(value = "", params = "movies")
    public ResponseEntity<List<CharacterDTO>> searchCharacterByMovie(@RequestParam Long movies) {
        try {
            List<CharacterDTO> charactersDTO = characterService.findByIdMovie(movies);

            if (!charactersDTO.isEmpty()) {
                return new ResponseEntity<>(charactersDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
