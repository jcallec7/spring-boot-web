package com.curso.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/variables")
public class PathVariableController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("pageTitle", "PathVariable Index");
        model.addAttribute("title", "Send params from @pathVariable");
        model.addAttribute("textController", "pathVariable");
        model.addAttribute("numberController", "5");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model){
        model.addAttribute("pageTitle", "pathVariable");
        model.addAttribute("title", "Receive param from @pathVariable");
        model.addAttribute("result", "The text sent is: " + text);
        return "variables/variable";
    }
    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text,@PathVariable Integer number, Model model){
        model.addAttribute("pageTitle", "pathVariable");
        model.addAttribute("title", "Receive some params from @pathVariable");
        model.addAttribute("result", "The text sent is: " + text + " and number is " + number);
        return "variables/variable";
    }
}
