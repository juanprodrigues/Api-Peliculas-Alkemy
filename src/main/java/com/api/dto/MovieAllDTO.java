package com.api.dto;


import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Data
public class MovieAllDTO {

    private Long id;
    private String imagen;
    private String titulo;
    private String fechaCreacion;
    private Integer calificacion;
    private Integer idGenero;
   
}
