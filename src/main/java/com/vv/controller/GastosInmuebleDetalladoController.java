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
        GastosInmueble gastosInmueble = new GastosInmueble();
        gastosInmueble = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
//Validar si se genero el recibo anterior
       if(gastosInmueble.getGenerado()){
           gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);
           gastosInmueble = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
       }else{
           //lista de BD de la tabla gastosDetallados
           listaDetallesGastosInmuebles = gastosDetalladosService.listaDetallesActuales(gastosInmueble);

       }

        //fin lista
        model.addObject("gastosInmueble",gastosInmueble);
        model.addObject("listadoGastos",listaDetallesGastosInmuebles);
        model.addObject("detallesGastosInmueble", detallesGastosInmueble = new DetallesGastosInmueble());
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
    @RequestMapping(value = "/guardarGastosM",method = RequestMethod.POST )
    public ModelAndView guardarGastosM(@ModelAttribute("detallesGastosInmueble") DetallesGastosInmueble detallesGastosInmueble,@ModelAttribute("gastosInmueble")GastosInmueble gastosInmueble) {
        gastosInmueble.setCondCondominio(1l);
        gastosInmueble.setGenerado(false);
        List<DetallesGastosInmueble> listaDetallesGastosInmuebles = gastosDetalladosService.listaDetallesActuales(gastosInmueble);
        Double subTotal=0.00;
        for(DetallesGastosInmueble det:listaDetallesGastosInmuebles){

            try {
                subTotal+= det.getMontoGasto();
            }catch (NullPointerException e){
                subTotal+=0.00;
            }
        }
        gastosInmueble.setMontoSubTotalGastosInmueble(subTotal);
        gastosDetalladosService.actualizaYGuardaGastoDetallado(detallesGastosInmueble);
        gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);

        return new ModelAndView("redirect:/gastosInmuebleM/");
    }

    @RequestMapping(value = "/guardarGastoInmueble",method = RequestMethod.POST )
    public String guardarGastoInmueble(@ModelAttribute("detallesGastosInmueble") DetallesGastosInmueble detallesGastosInmueble,@ModelAttribute("gastosInmueble")GastosInmueble gastosInmueble,Model model) {


            return "";
        }


    @RequestMapping(value="/actualizarTabla", method=RequestMethod.GET)
    public String getEventCount(@RequestParam(value = "codigo", required = false) String codigo,@RequestParam(value = "comentario", required = false) String comentario,@RequestParam(value = "monto", required = false) String monto,@RequestParam(value = "codigGastosInmueble", required = false) String codigGastosInmueble,Model model) {
        //Funcion para convertir en obj lo que viene del front
        Gastos gastos = new Gastos();
        GastosInmueble gastosInmueble = new GastosInmueble();
        gastosInmueble.setCodigGastosInmueble(Long.parseLong(codigGastosInmueble));
        gastosInmueble.setCondCondominio(01l);
        DetallesGastosInmueble detallesGastosInmueble = new DetallesGastosInmueble();
        gastos.setCodigGastos(Long.parseLong(codigo));
        detallesGastosInmueble.setDetallesGastoInmueble(comentario);
        detallesGastosInmueble.setMontoGasto(Double.parseDouble(monto));
        detallesGastosInmueble.setCodigGastosInmueble(gastosInmueble);
        detallesGastosInmueble.setCodigGastos(gastos);
        gastosDetalladosService.actualizaYGuardaGastoDetallado(detallesGastosInmueble);
        model.addAttribute("listadoGastos", gastosDetalladosService.listaDetallesActuales(gastosInmueble));
        // change "myview" to the name of your view
        return "gastosInmuebleM :: #tablaListaGastosR";
    }

}
