package com.CursoSpring.Aplicacao1.controllers;

import com.CursoSpring.Aplicacao1.model.Evento;
import com.CursoSpring.Aplicacao1.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {
    @Autowired
    private EventoRepository er;
    @RequestMapping(value="/cadastrarEvento",method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }
    @RequestMapping(value="/cadastrarEvento",method = RequestMethod.POST)
    public String form(Evento evento){
        er.save(evento);
        return  "redirect:/cadastrarEvento";
    }
    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mav = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();
        mav.addObject("eventos",eventos);
        return mav;

    }
}
