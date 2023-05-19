package com.curso.springboot.web.app.controller;

import com.curso.springboot.web.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"", "/", "/index", "/home"})
    public String index(Model model) {
        model.addAttribute("title", "Hello Spring Framework!");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User user = new User();
        user.setName("Jose Esteban");
        user.setSurname("Calle");
        user.setEmail("jcallec7@gmail.com");
        model.addAttribute("pageTitle", "Profile");
        model.addAttribute("title", "Perfil de: ".concat(user.getName()) + " " + user.getSurname());
        model.addAttribute("user", user);

        return "profile";
    }

    @GetMapping("/list")
    public String list(Model model) {


        model.addAttribute("pageTitle", "User list");
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> userList(){

        return Arrays.asList(
                new User("Jose Esteban", "Calle", "jcallec7@gmail.com"),
                new User("Tatiana", "Cardenas", "No email"),
                new User("Mateo", "Tamayo", "mtamayo@hotmail.com")
        );

    }
}
