package com.barbearia.fiodanavalha.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.barbearia.fiodanavalha.app.model.Procedimento;
import com.barbearia.fiodanavalha.app.repository.ProcedimentoRepository;

@Controller
public class ProcedimentoController {
    @Autowired
    private ProcedimentoRepository crs;

    @RequestMapping(value ="/", method=RequestMethod.GET)
    public ModelAndView procedimento(){
        ModelAndView mav = new ModelAndView("index");
        Iterable<Procedimento> procedimento = crs.findAll();
        mav.addObject("procedimentos", procedimento);
        return mav;
    }

    @RequestMapping(value = "/cadastrar-servico", method = RequestMethod.GET)
    public String cadastrarServico(){
        return "cadastrar-servico";
    }

    @RequestMapping(value ="/cadastrar-servico", method = RequestMethod.POST)
    public String cadastrarServico(Procedimento procedimento){
        crs.save(procedimento);
        return "redirect:/";
    }


    
}