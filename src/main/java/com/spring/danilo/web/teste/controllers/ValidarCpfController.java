package com.spring.danilo.web.teste.controllers;

import com.spring.danilo.web.teste.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ValidarCpfController {
	@GetMapping("/validar-cpf")
	public String index() {
		return "validarCpf/index";
	}

	@PostMapping("/validar-cpf/validar")
	public String validar(Cliente cliente, Model model) {
		boolean validado = cliente.validarCpf();
		model.addAttribute("validado", validado);
		model.addAttribute("cliente", cliente);
		return "validarCpf/validado";
	}
}