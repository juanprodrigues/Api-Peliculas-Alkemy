/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Entity
@Table(name = "Genders")
@Data
public class Gender {
    
    	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gender")
	private Long idGender;
	
        @NotBlank
	@Column(name = "title")
	private String name;
        
	@NotBlank
	@Column(name = "image")
	private String image;
	
//        @NotNull
//	@Column(name = "id_movie")
//	private long idMovie;
        
        //un genero pudee tener muchas peliculs
	
}
