/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.auth.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JuanPC
 */
@Data
public class UserDTO {
    @Email(message = "Username must be an email")
    private String username;
    @Size(min = 8)
    @NotNull
    private String password;
}

