package com.spring.danilo.web.teste.controllers;

import com.spring.danilo.web.teste.models.Cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
	public String index(Model model) {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("obs", "- Rosi e danilo - ");

		return "home/index";
	}

    @GetMapping("/direitos")
	public String direitos() {
		return "home/direitos";
	}

    @GetMapping("/teste")
	public String teste() {
		return " oippaaaa a"; // sem template
	}
}