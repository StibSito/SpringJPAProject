package com.ciberfarma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProyectoController {

	// controlador para abrir la pagina de saludo
	@GetMapping("/saludo")
	public String cargarPaginaSaludo() {
		return "saludo"; // para el retorno no es necesario colocar la extension
	}

	// controlador para leer los datos del campo y enviarlo a la pagina
	@PostMapping("/saludar")
	public String leerEnviar(@RequestParam(name = "txtNombre") String nombre, Model model) {
		model.addAttribute("mensaje", nombre);
		return "saludo";
	}

}
