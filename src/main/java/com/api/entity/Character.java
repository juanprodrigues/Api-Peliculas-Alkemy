/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.entity;

/**
 *
 * @author JuanPC
 */
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import javax.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "characters")
@Data
public class Character {

    @Id
    @Column(name = "id_character")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCharacter;

    @NotBlank
    @Column(name = "image")
    private String image;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "age")
    private Integer age;

    @NotNull
    @Column(name = "weight")
    private Double weight;

    @NotBlank
    @Column(name = "history")
    private String history;

    @NotNull
    @Column(name = "id_movie")
    private Long idMovie;
    //relacion uno a muchos
    // Un  personaje puede actuar en muchas peliculas

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", insertable = false, updatable = false)
    private Gender gender;



    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Set<Movie> movies = new HashSet<>();

}
