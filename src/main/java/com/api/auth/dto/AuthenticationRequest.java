/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.auth.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JuanPC
 */

@Getter
@Setter
public class AuthenticationRequest {
    private String username;
    private String password;
}

