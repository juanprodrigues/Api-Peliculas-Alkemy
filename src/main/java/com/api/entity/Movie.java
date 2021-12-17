/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Entity
@Table(name = "movies")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;

    @NotBlank
    @Column(name = "image")
    private String image;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "created_date")
    private LocalDate createdDate;

    @NotNull
    @Column(name = "qualification")
    private Integer qualification;

    @NotNull
    @Column(name = "id_gender")
    private Integer idGender;
    // Una pelicula puede tener muchas generos

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private List<Character> characters = new ArrayList<>();
       // Add and remove paises
    public void addPais(Character pais) {
        this.characters.add(pais);
    }

    public void removePais(Character pais) {
        this.characters.remove(pais);
    }

}
