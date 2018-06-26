package com.vv.controller;

import com.vv.model.Gastos;
import com.vv.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/gastos")
public class GastosController {

    @Autowired
    GastosService gastosService;

    //editar
    @RequestMapping(value="/updateGastos/{id}",method=RequestMethod.GET )
    public ModelAndView editArticle(@PathVariable long id) {
        ModelAndView model = new ModelAndView("gastosCRUD");
        Gastos gastos= gastosService.obtenerGasto(id);

        /*Vuelvo a consultar la lista y no
        la guardo en session ya que si otro usuario hace alguna modificacion esta se me actualize en tiempo real*/
        List<Gastos> listadoGastos = gastosService.listaGastos();
        model.addObject("listadoGastos",listadoGastos);
        model.addObject("gastosForm",gastos);
        return model;

    }

    //Guardar
    @RequestMapping(value="/saveGastos",method=RequestMethod.POST )
    public ModelAndView save(@ModelAttribute("gastosForm") Gastos gastos,@RequestParam(value="action", required=true) String action){
        if(action.toString().equalsIgnoreCase("cancel")){
            return new ModelAndView("redirect:/gastos/addGastos/");
        }else{
            gastosService.actualizaYGuarda(gastos);
            return new ModelAndView("redirect:/gastos/addGastos/");
        }
    }

    //Add Gastos
    //Agregar
    @RequestMapping(value="/addGastos/",method=RequestMethod.GET )
    public ModelAndView addGastos() {
        ModelAndView model = new ModelAndView();
        Gastos gastos =new Gastos();
        //Se iguala para que usuario pueda ver listas existentes
        List<Gastos> listadoGastos = gastosService.listaGastos();
        model.addObject("listadoGastos",listadoGastos);
        model.addObject("gastosForm",gastos);
        model.setViewName("gastosCRUD");
        return model;

    }



}
