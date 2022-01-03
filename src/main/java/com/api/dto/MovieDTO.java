/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dto;
import java.util.List;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Data
public class MovieDTO {
    private Long id;
    private String imagen;
    private String titulo;
    private String fechaCreacion;
    private Integer calificacion;
    private Integer idGenero;
    private List<CharacterDTO> characters;
}
