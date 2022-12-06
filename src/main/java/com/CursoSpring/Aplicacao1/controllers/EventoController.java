package com.CursoSpring.Aplicacao1.controllers;

import com.CursoSpring.Aplicacao1.model.Convidado;
import com.CursoSpring.Aplicacao1.model.Evento;
import com.CursoSpring.Aplicacao1.repository.ConvidadoRepository;
import com.CursoSpring.Aplicacao1.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EventoController {
    @Autowired
    private EventoRepository er;
    @Autowired
    private ConvidadoRepository cv;
    @RequestMapping(value="/cadastrarEvento",method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }
    @RequestMapping(value="/cadastrarEvento",method = RequestMethod.POST)
    public String form(@Valid Evento evento,BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEvento";
        }
        er.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
        return  "redirect:/cadastrarEvento";
    }
    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mav = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();
        mav.addObject("eventos",eventos);
        return mav;

    }
    @RequestMapping(value= "/{id}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("id") long id){
        Evento evento = er.findById(id);
        ModelAndView mav = new ModelAndView("evento/detalhesEvento");
        mav.addObject("evento",evento);
        Iterable<Convidado> convidados = cv.findByEvento(evento);
        mav.addObject("convidados", convidados);
        return mav;

    }
    @RequestMapping(value= "/{id}", method=RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("id") long id, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem","Verifique os campos!");
            return "redirect:/{id}";
        }
        Evento evento = er.findById(id);
        convidado.setEvento(evento);
        //evento.getConvidados().add(convidado);
        //er.save(evento);
        cv.save(convidado);
        attributes.addFlashAttribute("mensagem","Convidado adicionado com sucesso!");
        return "redirect:/{id}";

    }

}
