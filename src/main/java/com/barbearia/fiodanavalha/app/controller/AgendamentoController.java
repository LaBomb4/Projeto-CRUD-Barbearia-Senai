package com.barbearia.fiodanavalha.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.barbearia.fiodanavalha.app.model.Agendamento;
import com.barbearia.fiodanavalha.app.model.Procedimento;
import com.barbearia.fiodanavalha.app.repository.AgendamentoRepository;
import com.barbearia.fiodanavalha.app.repository.ProcedimentoRepository;

@Controller
public class AgendamentoController {
    @Autowired
    private AgendamentoRepository csr;

    @Autowired
    private ProcedimentoRepository pr;

    @RequestMapping(value = "/home-usuario", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("home-usuario");
        Iterable<Agendamento> agendamento = csr.findAll();
        mv.addObject("agendamento", agendamento);
        return mv;
    }

    @RequestMapping(value = "/agendar", method = RequestMethod.GET)
    public ModelAndView agendar() {
        ModelAndView mv = new ModelAndView("agendar");
        Iterable<Procedimento> procedimento = pr.findAll();
        mv.addObject("procedimentos", procedimento);
        return mv;
    }

    @RequestMapping(value = "/agendar", method = RequestMethod.POST)
    public String agendar(Agendamento agendamento) {
        csr.save(agendamento);
        return "redirect:/";
    }

    @RequestMapping(value = "/editarAgendamento/{idAgendamento}", method = RequestMethod.GET)
    public ModelAndView editarAgendamento(@PathVariable("idAgendamento") long idAgendamento) {
        Agendamento agendamento = csr.findByIdAgendamento(idAgendamento);
        ModelAndView mv = new ModelAndView("editar-agendamento");
        mv.addObject("agendamento", agendamento);

        Iterable<Procedimento> procedimento = pr.findAll();
        mv.addObject("procedimentos", procedimento);
        return mv;
    }

    @RequestMapping(value = "editarAgendamento/{idAgendamento}", method = RequestMethod.POST)
    public String editarAgendamento(@Validated Agendamento agendamento, BindingResult result,
            RedirectAttributes attributes) {
        csr.save(agendamento);
        return "redirect:/home-usuario";
    }

    @RequestMapping("/confirmarExclusao/{idAgendamento}")
    public ModelAndView confirmarExclusao(@PathVariable("idAgendamento") long idAgendamento) {
        Agendamento agendamento = csr.findByIdAgendamento(idAgendamento);
        ModelAndView mv = new ModelAndView("excluir-agendamento");
        mv.addObject("agendamento", agendamento);
        return mv;

    }

    @RequestMapping("/excluirAgendamento")
    public String excluirEvento(long idAgendamento) {
        Agendamento agendamento = csr.findByIdAgendamento(idAgendamento);
        csr.delete(agendamento);
        return "redirect:/home-usuario";
    }

}