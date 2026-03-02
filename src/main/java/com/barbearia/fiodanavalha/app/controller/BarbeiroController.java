package com.barbearia.fiodanavalha.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

    @GetMapping("/dashboard")
    public String dashboardBarbeiro() {
        return "Área exclusiva do Barbeiro";
    }
}