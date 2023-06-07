package com.curso.springboot.web.app.controller;

import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/mix-params")
    public String param(@RequestParam String text, @RequestParam String number, Model model) {
        model.addAttribute("pageTitle", "Params");
        model.addAttribute("title", "Receive some params from the request GET - URL");
        model.addAttribute("result", "The text sent is: " + text + " and number is " + number);
        return "params/param";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String text = request.getParameter("text");
        Integer number = 0;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        }catch (NumberFormatException e){
            number = 0;
        }
        model.addAttribute("pageTitle", "Params");
        model.addAttribute("title", "Receive some servlet params from the request GET - URL");
        model.addAttribute("result", "The text sent is: " + text + " and number is " + number);
        return "params/param";
    }


}
