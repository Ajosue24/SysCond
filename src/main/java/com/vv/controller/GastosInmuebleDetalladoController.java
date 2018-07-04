package com.vv.controller;


import com.vv.model.DetallesGastosInmueble;
import com.vv.model.Gastos;
import com.vv.model.GastosInmueble;
import com.vv.model.Item;
import com.vv.service.GastosInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GastosInmuebleDetalladoController {


    @Autowired
    GastosInmuebleService gastosInmuebleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPages() {
        ModelAndView model = new ModelAndView("gastosInmuebleM");
        String nombreGasto = "hola";
       GastosInmueble gastosInmueble = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
        DetallesGastosInmueble item = new DetallesGastosInmueble();

        //lista prueba
        DetallesGastosInmueble obj = new DetallesGastosInmueble();
        List<DetallesGastosInmueble> listadoDetGInm = new ArrayList<>();
        obj.setMontoGasto(5000.00);
        Gastos g = new Gastos();
        g.setCodigGastos(1);
        g.setDescrGastos("test");
        obj.setCodigGastos(g);
        obj.setDetallesGastoInmueble("Comentario");
        listadoDetGInm.add(obj);
        model.addObject("listadoGastos",listadoDetGInm);
        //fin lista prueba

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
        ModelAndView model = new ModelAndView("/gastosInmuebleM/");
        DetallesGastosInmueble obj = new DetallesGastosInmueble();
        List<DetallesGastosInmueble> listadoDetGInm = new ArrayList<>();
        obj.setMontoGasto(5000.00);
        Gastos g = new Gastos();
        g.setCodigGastos(1);
        obj.setCodigGastos(g);
        obj.setDetallesGastoInmueble("prueba");
        listadoDetGInm.add(obj);
        model.addObject("listadoGastos",obj);
        return model;
    }

}
