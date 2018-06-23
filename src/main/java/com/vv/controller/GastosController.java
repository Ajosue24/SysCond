package com.vv.controller;

import com.vv.model.Gastos;
import com.vv.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/gastos")
public class GastosController {

    @Autowired
    GastosService gastosService;


    //Muestra Todos los gastos en una lista llamada listadoGastos
    @RequestMapping(value="/listaGastos",method=RequestMethod.GET)
    public ModelAndView pruebaPagos(){
        ModelAndView model = new ModelAndView("gastosCRUD");
        /* el viewname coloco el nombre del html*/
        List<Gastos> listadoGastos = gastosService.listaGastos();
        model.addObject("listadoGastos",listadoGastos);
        return model;
    }

    //editar
    @RequestMapping(value="/updateGastos/{id}",method=RequestMethod.GET )
    public String editArticle(@PathVariable long id) {
        ModelAndView model = new ModelAndView();
        Gastos gastos=gastosService.obtenerGasto(id);
        model.addObject("gastosForm",gastos);
        return "gastosCRUD :: #item";

    }

    //Guardar
    @RequestMapping(value="/saveGastos",method=RequestMethod.POST )
    public ModelAndView save(@ModelAttribute("articleForm") Gastos gastos) {
        gastosService.actualizaYGuarda(gastos);
        return new ModelAndView("redirect:/gastos/listaGastos");


    }



}
