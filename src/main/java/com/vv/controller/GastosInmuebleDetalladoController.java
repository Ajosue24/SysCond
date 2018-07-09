package com.vv.controller;


import com.vv.model.DetallesGastosInmueble;
import com.vv.model.Gastos;
import com.vv.model.GastosInmueble;
import com.vv.model.Item;
import com.vv.repository.GastosInmuebleDetalladoRepository;
import com.vv.service.GastosInmuebleDetalladoService;
import com.vv.service.GastosInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
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
        GastosInmueble gastosInmueble;
        gastosInmueble = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
        gastosInmueble.setGenerado(gastosInmueble.getGenerado()==null?false:gastosInmueble.getGenerado());
//Validar si se genero el recibo anterior
       if(gastosInmueble.getGenerado()){
           gastosInmueble=new GastosInmueble();
           gastosInmueble.setCondCondominio(1l);
           gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);
       }else{
           //lista de BD de la tabla gastosDetallados
           listaDetallesGastosInmuebles = gastosDetalladosService.listaDetallesActuales(gastosInmueble);

       }
for(DetallesGastosInmueble listaGastosInmuebleD:listaDetallesGastosInmuebles){
    gastosInmueble.setMontoSubTotalGastosInmueble(listaGastosInmuebleD.getMontoGasto());
}

        //fin lista
        model.addObject("gastosInmueble",gastosInmueble);
        model.addObject("listadoGastos",listaDetallesGastosInmuebles);
        model.addObject("formDetallesGastosInmueble",new DetallesGastosInmueble());
        return model;

    }


//Como refrescar por el get
/*    @RequestMapping(value = "/refreshNombreFecha", method = RequestMethod.GET)
    public String refreshItem(@RequestParam("descrGastosInmueble") String descrGastosInmueble, Model model) {
        Item item = new Item();
        item.setId(1);
        item.setNombre("algo");
        model.addAttribute("itemForm", item);
        return "gastosInmuebleM :: #item";
    }*/


    @RequestMapping(value = "/refreshNombreFecha", method = RequestMethod.GET)
    public String refreshNombreFecha(@RequestParam("descrGastosInmueble") String descrGastosInmueble, Model model) {
        GastosInmueble item = new GastosInmueble();
        item.setDescrGastosInmueble("prueba");
        item.setFechaGastosInmueble(new Date());
        model.addAttribute("gastosInmueble", item);
        return "gastosInmuebleM :: #gastosInmuebleHeader";
    }

    @RequestMapping(value = "/guardarGastosM",method = RequestMethod.POST)
    public ModelAndView guardarGastosM(@Valid @ModelAttribute("formDetallesGastosInmueble") DetallesGastosInmueble detallesGastosInmueble,
                                       @RequestParam(value="finalizarG", required=false) String finalizarG,
                                       BindingResult bindingResult,ModelAndView model) {

        try{
            model.setViewName("/gastosInmuebleM");
            if(bindingResult.hasErrors()){
                model.addObject("detallesGastosInmueble",detallesGastosInmueble);
                return model;
            }
            if(finalizarG == null){
               /* gastosInmueble.setCondCondominio(1l);
                gastosInmueble.setGenerado(false);*/
                gastosDetalladosService.actualizaYGuardaGastoDetallado(detallesGastosInmueble);
               /* gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);*/
            }else{
            /*    gastosInmueble.setCondCondominio(1l);
                gastosInmueble.setGenerado(true);
                gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);*/
            }

        }catch (DataIntegrityViolationException e){
            bindingResult.rejectValue("codigGastos", "maxDigit.policyHolder.mobile", "Ingrese Un Gasto Valido");
            model.addObject("gastosInmueble",new GastosInmueble());
            return model;
        }




return  model;

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
        // change "myview" to the name of your view
        return "gastosInmuebleM :: #tablaListaGastosR";
    }

}
