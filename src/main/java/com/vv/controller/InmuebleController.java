package com.vv.controller;

import com.vv.model.Inmueble;
import com.vv.model.TipoInmueble;
import com.vv.service.InmuebleService;
import com.vv.service.TipoInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/inmuebles")
public class InmuebleController {

    @Autowired
    TipoInmuebleService tipoInmuebleService;

    @Autowired
    InmuebleService inmuebleService;

    @RequestMapping(value = "/",method=RequestMethod.GET )
    public ModelAndView cargarViewInmueble(){
        ModelAndView model = new ModelAndView("inmueblesCRUD");
        Inmueble inmueble = new Inmueble();

        List<TipoInmueble> listaTipoInmueble;
        listaTipoInmueble = tipoInmuebleService.listaTipoInmueble();
        List<Inmueble> listaInmuebles = inmuebleService.obtenerListaInmuebles();
        model.addObject("listaInmuebles",listaInmuebles);
        model.addObject("listaTipoInmueble",listaTipoInmueble);
        model.addObject("inmueblesForm",inmueble);
        return model;
    }


    @RequestMapping(value = "/guardarInmueble",method=RequestMethod.POST )
    public ModelAndView guardarInmueble(@Valid @ModelAttribute("inmueblesForm") Inmueble inmueble, BindingResult bindingResult,ModelAndView model){
        model.setViewName("/inmueblesCRUD");
        if(bindingResult.hasErrors()){
            model.addObject("inmueble",inmueble);
             return model;
        }
        inmuebleService.guardarEditarInmueble(inmueble);

        model.addObject("listaInmuebles",inmuebleService.obtenerListaInmuebles());
        model.addObject("listaTipoInmueble",tipoInmuebleService.listaTipoInmueble());
        model.addObject("inmueblesForm",new Inmueble());
        return model;

    }

    //editar
    @RequestMapping(value="/actualizarInmueble/{nombreInmueble}",method=RequestMethod.GET )
    public ModelAndView actualizarInmueble(@PathVariable String nombreInmueble) {
        ModelAndView model = new ModelAndView("inmueblesCRUD");
        Inmueble inmueble = inmuebleService.obtenerInmueble(nombreInmueble);
        List<TipoInmueble> listaTipoInmueble;
        listaTipoInmueble = tipoInmuebleService.listaTipoInmueble();
        List<Inmueble> listaInmuebles = inmuebleService.obtenerListaInmuebles();
        model.addObject("listaInmuebles",listaInmuebles);
        model.addObject("listaTipoInmueble",listaTipoInmueble);
        model.addObject("inmueblesForm",inmueble);
        return model;
    }




}
