package com.vv.controller;

import com.vv.model.UserAndRol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by alexis.vasquez on 15/3/2018.
 */
@Controller
public class UserController {


    @GetMapping("/")
    public String home() {
        return "login";
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/header")
    public String header() {
        return "staticTemplates/header";
    }

    @GetMapping("/pruebaPagos")
    public String pruebaPagos() {
        return "PruebaPagos";
    }


 /* @GetMapping
    public String index(Model model, Principal principal){
        model.addAttribute("loggedInUser",principal.getName());
        return "index";
    }*/

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        UserAndRol userEntity =  new UserAndRol();
        model.addObject("user",userEntity);

        return model;
    }
}

