package com.vv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by alexis.vasquez on 15/3/2018.
 */
@Controller
public class UserController {


    @GetMapping("/")
    public String home() {
        return "index";
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

/*metodo valida que usuario se encuentre autenticado
*
  @GetMapping
    public String index(Model model, Principal principal){
        model.addAttribute("loggedInUser",principal.getName());
        return "index";
    }*/
}

