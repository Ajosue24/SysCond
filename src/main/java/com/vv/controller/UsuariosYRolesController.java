package com.vv.controller;


import com.vv.model.UserAndRol;
import com.vv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/usuariosYRoles")
public class UsuariosYRolesController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/",method=RequestMethod.GET )
    public ModelAndView inicioRecibosGenerales() {
        ModelAndView model = new ModelAndView("usuariosYRoles");
        model.addObject("listaUsuarios",userService.listaUsuario());
        model.addObject("formUsuariosYRoles",new UserAndRol());
        return model;
    }

     @RequestMapping(value="/guardarUsuarioyRol",method=RequestMethod.POST )
    public ModelAndView guardarUsuarioyRol(@ModelAttribute("formUsuariosYRoles") UserAndRol userAndRol) {
        ModelAndView model = new ModelAndView("usuariosYRoles");
         model.addObject("listaUsuarios",userService.listaUsuario());
         model.addObject("formUsuariosYRoles",new UserAndRol());
        return model;
     }






}
