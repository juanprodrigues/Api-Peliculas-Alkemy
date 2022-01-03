package com.api.dto;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Data
public class CharacterDTOAll {
    private Long id_character;
    private String image;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    private Long id_movie;   
}