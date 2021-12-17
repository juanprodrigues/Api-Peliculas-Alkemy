/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dto;
import com.api.entity.Character;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Data
public class MovieBasicDTO {
    private Long id;
    private String imagen;
    private String titulo;
    private String fechaCreacion;
    private Integer calificacion;
    private Integer idGenero;
    private List<Character> characters;
}
