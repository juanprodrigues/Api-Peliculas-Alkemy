/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.builder;

import com.api.entity.Gender;

/**
 *
 * @author JuanPC
 */
public class GenderBuilder {
     private Gender gender;

    public GenderBuilder() {
        this.gender = new Gender();
    }

    public GenderBuilder imagen(String imagen) {
        this.gender.setImage(imagen);
        return this;
    }

    public GenderBuilder nombre(String dominacion) {
        this.gender.setName(dominacion);
        return this;
    }

    public Gender build() {
        return gender;
    }


}
