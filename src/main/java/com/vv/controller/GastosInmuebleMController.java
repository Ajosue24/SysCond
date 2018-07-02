package com.vv.controller;


import com.vv.model.DetallesGastosInmueble;
import com.vv.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/gastosInmuebleM")
public class GastosInmuebleMController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPages() {
        ModelAndView model = new ModelAndView("gastosInmuebleM");
        String nombreGasto = "hola";
        DetallesGastosInmueble item = new DetallesGastosInmueble();
        model.addObject("nombreGasto",nombreGasto);
        model.addObject("detGastoInm", item);
        return model;

    }



    @RequestMapping(value = "/refreshGasto", method = RequestMethod.GET)
    public String refreshItem(/*@RequestParam("order") String orderId,*/ Model model) {
        Item item = new Item();
        item.setId(1);
        item.setNombre("algo");
        model.addAttribute("itemForm", item);
        return "gastosInmuebleM :: #item";
    }
    @RequestMapping(value = "/guardarGastosM",method=RequestMethod.POST )
    public ModelAndView guardarGastosM(@ModelAttribute("detGastoInm") DetallesGastosInmueble detallesGastosInmueble, @RequestParam(value="descGM", required=false) String descGM) {

        return new ModelAndView("redirect:/gastosInmuebleM/");
    }

}
