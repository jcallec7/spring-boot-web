package com.curso.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home () {
        //redirect cambia la ruta del navegador
        //forward no la cambia
        return "forward:/app/index";
    }
}
