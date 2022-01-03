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
	
        
	@Column(name = "title")
	private String name;
        
	
	@Column(name = "image")
	private String image;
	
//        @NotNull
//	@Column(name = "id_movie")
//	private long idMovie;
        
        //un genero pudee tener muchas peliculs
	
}
