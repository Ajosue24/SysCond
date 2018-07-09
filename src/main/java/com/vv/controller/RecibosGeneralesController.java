package com.vv.controller;

import com.vv.model.GastosInmueble;
import com.vv.service.GastosInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/recibosGenerales")
public class RecibosGeneralesController {

    @Autowired
    GastosInmuebleService gastosInmuebleService;

    @RequestMapping(value="/",method=RequestMethod.GET )
    public ModelAndView inicioRecibosGenerales(){
        ModelAndView model = new ModelAndView("listaRecibosGenerales");
        List<GastosInmueble> listaGastosInmuebleNoFinalizados;
        listaGastosInmuebleNoFinalizados = gastosInmuebleService.obtenerListaGastosInmuebleNoFinalizados();
        List<GastosInmueble> listaGastosInmuebleFinalizados;
        listaGastosInmuebleFinalizados = gastosInmuebleService.obtenerListaGastosInmuebleFinalizados();
        model.addObject("listaRecibosNoGenerados",listaGastosInmuebleNoFinalizados);
        model.addObject("listaRecibosFinalizados",listaGastosInmuebleFinalizados);
        model.addObject("GastosInmuebleForm",new GastosInmueble());
        return model;
    }


    @RequestMapping(value = "/crearNuevoRecibo",method = RequestMethod.POST)
    public ModelAndView crearNuevoRecibo(@Valid @ModelAttribute("GastosInmuebleForm") GastosInmueble gastosInmueble, BindingResult bindingResult, ModelAndView model, RedirectAttributes redirectAttributes){
        bindingResult.rejectValue("codigGastos", "maxDigit.policyHolder.mobile", "Please enter valid mobile");

        if(bindingResult.hasErrors()){
            model.addObject(gastosInmueble);
            model.setViewName("/listaRecibosGenerales");
            return model;
        }

        return model;
    }
}
