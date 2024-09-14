package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ciberfarma.model.Usuario;
import com.ciberfarma.repository.IUsuarioRepository;
@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioRepository repoUsr;
	
	
	@GetMapping("/cargarUsuario")
	public String cargarPagina(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "crudUsuario";
	}

	
	
	@PostMapping("/leerUsuario")
	public String leerUsuario(@ModelAttribute Usuario usuario) {
		repoUsr.save(usuario);
		System.out.println(usuario);
		return "crudUsuario";
	}
}
