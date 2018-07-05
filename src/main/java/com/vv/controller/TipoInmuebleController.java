package com.vv.controller;

import com.vv.model.TipoInmueble;
import com.vv.service.TipoInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value ="/tipoInmueble" )
public class TipoInmuebleController {

    @Autowired

    TipoInmuebleService tipoInmuebleService;

    //editar
    @RequestMapping(value ="/updateTipoInmueble/{id}",method = RequestMethod.GET)
    public ModelAndView editArticle(@PathVariable long id) {
        ModelAndView model = new ModelAndView("tipoInmuebleCRUD");
        TipoInmueble tipoInmueble = tipoInmuebleService.obtenerTipoInmueble(id);

        /*Se Vuelve a consultar la lista y no se guarda en session ya que si otro usuario
         hace alguna modificacion esta se actualice en tiempo real*/
        List<TipoInmueble> listadoTipoInmueble = tipoInmuebleService.listaTipoInmueble();
        model.addObject("listadoTipoInmueble", listadoTipoInmueble);
        model.addObject("tipoInmuebleForm", tipoInmueble);
        return model;
    }
    //Guardar
    @RequestMapping(value = "saveTipoInmueble",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("tipoInmuebleForm") TipoInmueble tipoInmueble,
                             @RequestParam(value = "action",required = true) String action){
        if(action.toString().equalsIgnoreCase("cancel")){
            return new ModelAndView("redirect:/tipoInmuble/addTipoInmueble/");
        }else {
            tipoInmuebleService.actualizaYGuarda(tipoInmueble);
            return new ModelAndView("redirect:/tipoInmueble/addTipoInmueble/");
        }
        }
    //Add Gastos
    //Agregar
    @RequestMapping(value = "/addTipoInmueble/",method = RequestMethod.GET)
    public ModelAndView addTipoInmueble(){
        ModelAndView model = new ModelAndView();
        TipoInmueble tipoInmueble = new TipoInmueble();
        //Se iguala para que usuario pueda ver listas existentes
        List<TipoInmueble> listadoTipoInmueble = tipoInmuebleService.listaTipoInmueble();
        model.addObject("listadoTipoInmueble",listadoTipoInmueble);
        model.addObject("tipoInmuebleForm",tipoInmueble);
        model.setViewName("tipoInmuebleCRUD");
        return model;
    }
}
