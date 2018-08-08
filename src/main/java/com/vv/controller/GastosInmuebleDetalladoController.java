package com.vv.controller;


import com.vv.model.*;
import com.vv.repository.GastosInmuebleDetalladoRepository;
import com.vv.service.GastosInmuebleDetalladoService;
import com.vv.service.GastosInmuebleService;
import com.vv.service.InmuebleService;
import com.vv.service.MovimientosInmuebleService;
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
import javax.validation.constraints.Null;
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

    @Autowired
    InmuebleService inmuebleService;

    @Autowired
    MovimientosInmuebleService movimientosInmuebleService;

    private GastosInmueble gastosInmueble;

    GastosInmuebleDetalladoController(){
        gastosInmueble = new GastosInmueble();
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPages() {
        ModelAndView model = new ModelAndView("gastosInmuebleM");
        gastosInmueble = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
        List<DetallesGastosInmueble> listaDetallesGastosInmuebles = new ArrayList<>();
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



    @RequestMapping(value = "/guardarGastosM",method = RequestMethod.POST)
    public ModelAndView guardarGastosM(@Valid @ModelAttribute("formDetallesGastosInmueble") DetallesGastosInmueble detallesGastosInmueble,
                                       @RequestParam(value="finalizarG", required=false) String finalizarG,
                                       BindingResult bindingResult,ModelAndView model) {
        gastosInmueble = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
        List<DetallesGastosInmueble> listaDetallesGastosInmuebles = new ArrayList<>();
        model.setViewName("/gastosInmuebleM");
        try{
            if(bindingResult.hasErrors()){
                model.addObject("detallesGastosInmueble",detallesGastosInmueble);
                return model;
            }
            if(finalizarG == null){
                gastosInmueble.setCondCondominio(1l);
                gastosInmueble.setGenerado(false);
                //Actualizar monto
                gastosInmueble.setMontoSubTotalGastosInmueble(gastosInmueble.getMontoSubTotalGastosInmueble()== null?detallesGastosInmueble.getMontoGasto():gastosInmueble.getMontoSubTotalGastosInmueble()+detallesGastosInmueble.getMontoGasto());
                gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);
                detallesGastosInmueble.setCodigGastosInmueble(gastosInmueble);
                gastosDetalladosService.actualizaYGuardaGastoDetallado(detallesGastosInmueble);
               /* gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);*/
            }else{
              gastosInmueble.setCondCondominio(1l);
                gastosInmueble.setGenerado(true);
                gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);
               listaDetallesGastosInmuebles = gastosDetalladosService.listaDetallesActuales(gastosInmueble);
                List<Inmueble> listaInmuebles= inmuebleService.obtenerListaInmuebles();
                try {
                    for(Inmueble inmueble:listaInmuebles){
                        registrarPorCadaInmueble(inmueble);
                        generarPDF(inmueble,listaDetallesGastosInmuebles);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                return getPages();
            }

        }catch (DataIntegrityViolationException e){
            listaDetallesGastosInmuebles= gastosDetalladosService.listaDetallesActuales(gastosInmueble);
            bindingResult.rejectValue("codigGastos", "error", "Ingrese Un Gasto Valido");
            model.addObject("gastosInmueble",gastosInmueble);
            model.addObject("listadoGastos",listaDetallesGastosInmuebles);

            return model;
        }
        listaDetallesGastosInmuebles= gastosDetalladosService.listaDetallesActuales(gastosInmueble);
        model.addObject("gastosInmueble",gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado());
        model.addObject("listadoGastos",listaDetallesGastosInmuebles);
        model.addObject("formDetallesGastosInmueble",new DetallesGastosInmueble());

return  model;

    }

    @RequestMapping(value="/updateGastosDetallados/{id}",method=RequestMethod.GET )
    public ModelAndView updateGastosDetallados(@PathVariable long id) {
        ModelAndView model = new ModelAndView("gastosInmuebleM");
        DetallesGastosInmueble detallesGastosInmueble = new DetallesGastosInmueble();
        detallesGastosInmueble = gastosDetalladosService.buscarDetallesGastosInmueblePorId(id);

        /*Vuelvo a consultar la lista y no
        la guardo en session ya que si otro usuario hace alguna modificacion esta se me actualize en tiempo real*/
        List<DetallesGastosInmueble> listaDetallesGastosInmuebles = gastosDetalladosService.listaDetallesActuales(gastosInmueble);
        model.addObject("gastosInmueble",gastosInmueble);
        model.addObject("listadoGastos",listaDetallesGastosInmuebles);
        model.addObject("formDetallesGastosInmueble",detallesGastosInmueble);
        return model;
    }

    @RequestMapping(value="/borrarGastosDetallados/{id}",method=RequestMethod.GET )
    public ModelAndView borrarGastosDetallados(@PathVariable long id) {
        ModelAndView model = new ModelAndView("gastosInmuebleM");
        GastosInmueble gi = new GastosInmueble();
        //actualizo monto sub total
        gi = gastosInmuebleService.obtenerGastoInmuebleSiNofinalizado();
        try{
            gi.setMontoSubTotalGastosInmueble(gi.getMontoSubTotalGastosInmueble() - gastosDetalladosService.buscarDetallesGastosInmueblePorId(id).getMontoGasto());
        }catch (NullPointerException e){
            gi.setMontoSubTotalGastosInmueble(0.00);
        }

        gastosInmuebleService.guardarActualizarGastoInmueble(gi);
        gastosDetalladosService.eliminarGastoDetallado(id);
        List<DetallesGastosInmueble> listaDetallesGastosInmuebles = gastosDetalladosService.listaDetallesActuales(gastosInmueble);
        model.addObject("gastosInmueble",gi);
        model.addObject("listadoGastos",listaDetallesGastosInmuebles);
        model.addObject("formDetallesGastosInmueble",new DetallesGastosInmueble());
        return model;

    }
//Guarda Informacion del recibo para el inmueble
    private void registrarPorCadaInmueble(Inmueble inmueble){
        MovimientosInmuebles movimientosInmuebles = new MovimientosInmuebles();
        movimientosInmuebles.setCodigGastosInmueble(gastosInmueble);
        movimientosInmuebles.setCodigInmueble(inmueble);
        movimientosInmuebles.setFechaMov(gastosInmueble.getFechaGastosInmueble());
        movimientosInmuebles.setMontoMensualMov((gastosInmueble.getMontoSubTotalGastosInmueble()*inmueble.getAlicuota())/100);
        movimientosInmuebles.setIfCancelado(false);
        movimientosInmuebleService.guardarMovimientosInmueble(movimientosInmuebles);
    }
//Genera PDF correspondiente
private void  generarPDF(Inmueble inmueble,List<DetallesGastosInmueble> listadoGastos){

       // movimientosInmuebleService.listarPorNumeroDeRecibo(gastosInmueble.getCodigGastosInmueble());

         RecibosOFacturas recibosOFacturas = new RecibosOFacturas();
         try {
             recibosOFacturas.generatePdf(gastosInmueble,listadoGastos,inmueble,movimientosInmuebleService.obtenerMovPorReciboEInmueble(gastosInmueble,inmueble));
         }catch (Exception e){
             e.printStackTrace();
         }



     /*gastosInmuebleInf;
    gastosInmueble;
    listaDetallesGastosInmuebles;
    inmuebleInf*/

}
}
