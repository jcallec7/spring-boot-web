package com.curso.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("pageTitle", "Send param");
        model.addAttribute("title", "Send params from the request GET - URL");
        return "params/index";
    }
    @GetMapping("/string")
    public String param(@RequestParam(defaultValue = "No value in param") String text, Model model) {
        model.addAttribute("pageTitle", "Params");
        model.addAttribute("title", "Receive params from the request GET - URL");
        model.addAttribute("result", "The text sent is: " + text);
        return "params/param";
    }


}
