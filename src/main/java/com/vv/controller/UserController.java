package com.vv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by alexis.vasquez on 15/3/2018.
 */
@Controller
public class UserController {


    @GetMapping("/")
    public String home() {
        return "index";
    }


/*metodo valida que usuario se encuentre autenticado
  @GetMapping
    public String index(Model model, Principal principal){
        model.addAttribute("loggedInUser",principal.getName());
        return "index";
    }*/
}
