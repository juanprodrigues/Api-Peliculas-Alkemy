/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
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

 
    @Column(name = "image")
    private String image;

  
    @Column(name = "title")
    private String title;

   
    @Column(name = "created_date")
    private LocalDate createdDate;

    
    @Column(name = "qualification")
    private Integer qualification;

    
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
