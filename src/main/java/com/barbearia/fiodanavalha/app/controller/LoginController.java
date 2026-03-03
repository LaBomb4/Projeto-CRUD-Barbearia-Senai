package com.barbearia.fiodanavalha.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String telaLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logar(String usuario, String senha, HttpSession session, RedirectAttributes attributes) {
        
        // Lógica simples: se o usuário for 'admin' e senha '123', é Barbeiro
        if ("admin".equals(usuario) && "123".equals(senha)) {
            session.setAttribute("perfil", "barbeiro");
            return "redirect:/home-usuario";
        } 
        
        attributes.addFlashAttribute("erro", "Usuário ou senha inválidos!");
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Limpa o acesso
        return "redirect:/";
    }
}