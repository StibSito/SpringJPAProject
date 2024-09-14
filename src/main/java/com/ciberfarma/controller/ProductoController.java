package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ciberfarma.model.Producto;
import com.ciberfarma.repository.ICategoriaRepository;
import com.ciberfarma.repository.IProductoRepository;
import com.ciberfarma.repository.IProveedorRepository;

@Controller
public class ProductoController {

	// objs de repositorio
	@Autowired
	private ICategoriaRepository repoCat;

	@Autowired
	private IProductoRepository repoProd;

	@Autowired
	private IProveedorRepository repProve;

	// to control the page and read all the attributes
	@GetMapping("/cargarProductos")
	public String leerPagina(Model model) {
		model.addAttribute("producto", new Producto());

		// enviar listado
		model.addAttribute("lstProductos", repoProd.findAll());
		model.addAttribute("lstCategorias", repoCat.findAll());
		model.addAttribute("lstProveedores", repProve.findAll());

		return "crudProductos";
	}

	@GetMapping("/editarProducto/{id}")
	public String editarProducto(@PathVariable("id") String id_prod, Model model) {
		// Buscar el producto por su ID
		Producto producto = repoProd.findById(id_prod).orElse(null);

		// Verificar si el producto existe
		if (producto != null) {
			model.addAttribute("producto", producto); // Cargar el producto en el formulario
		} else {
			model.addAttribute("mensaje", "Producto no encontrado");
			model.addAttribute("claseMensaje", "alert alert-danger");
		}

		// Recargar los listados de categorías y proveedores
		model.addAttribute("lstProductos", repoProd.findAll());
		model.addAttribute("lstCategorias", repoCat.findAll());
		model.addAttribute("lstProveedores", repProve.findAll());

		return "crudProductos"; // Redirigir a la misma página del formulario
	}

	// read data from the form
	@PostMapping("/registrar")
	public String registrarProducto(@ModelAttribute Producto producto, Model model) {
		System.out.println(producto);

		try {
			repoProd.save(producto);
			model.addAttribute("lstProductos", repoProd.findAll());
			model.addAttribute("lstCategorias", repoCat.findAll());
			model.addAttribute("lstProveedores", repProve.findAll());

			model.addAttribute("mensaje", "Registro de producto OK");
			model.addAttribute("claseMensaje", "alert alert-success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mensaje", "Error en el registro ");
			model.addAttribute("claseMensaje", "alert alert-danger");
			e.printStackTrace();
		}
		return "crudProductos";
	}

}
