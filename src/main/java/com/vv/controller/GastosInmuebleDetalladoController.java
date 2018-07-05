package com.vv.controller;


import com.vv.model.DetallesGastosInmueble;
import com.vv.model.Gastos;
import com.vv.model.GastosInmueble;
import com.vv.model.Item;
import com.vv.repository.GastosInmuebleDetalladoRepository;
import com.vv.service.GastosInmuebleDetalladoService;
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

    @Autowired
    GastosInmuebleDetalladoService gastosDetalladosService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPages() {
        ModelAndView model = new ModelAndView("gastosInmuebleM");
        List<DetallesGastosInmueble> listaDetallesGastosInmuebles = new ArrayList<>();
        DetallesGastosInmueble detallesGastosInmueble;
       GastosInmueble gastosInmueble = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
       if(gastosInmueble.getGenerado()!= null && gastosInmueble.getGenerado()){
           gastosInmuebleService.guardarActualizarGastoInmueble(new GastosInmueble());
       }else{
           //lista de BD de la tabla gastosDetallados
           listaDetallesGastosInmuebles = gastosDetalladosService.listaDetallesActuales(gastosInmueble.getCodigGastosInmueble());
       }




        //fin lista
        model.addObject("gastosInmueble",gastosInmueble);
        model.addObject("listadoGastos",listaDetallesGastosInmuebles);
        model.addObject("detGastoInm", detallesGastosInmueble = new DetallesGastosInmueble());
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
        gastosDetalladosService.actualizaYGuardaGastoDetallado(detallesGastosInmueble);
        return model;
    }

}
