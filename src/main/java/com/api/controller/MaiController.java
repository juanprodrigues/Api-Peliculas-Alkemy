/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JuanPC
 */
@Controller
public class MaiController {

    @GetMapping("/")
    public String login() {
        //ModelAndView mav = new ModelAndView("/auth/ingreso.html");
        return "/auth/ingreso.html";
    }

    @GetMapping("/ingreso")
    public ModelAndView registrarse() {
        ModelAndView mav = new ModelAndView("/auth/registro.html");
        return mav;
    }

    @GetMapping("/personajes")
    public ModelAndView personajes() {
        ModelAndView mav = new ModelAndView("/character/personajes.html");
        return mav;
    }
}
