/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.exception;

/**
 *
 * @author JuanPC
 */
public class ParamNotFound extends RuntimeException {

    public ParamNotFound(String error) {
        super(error);
    }
}
