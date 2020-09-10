package relaciones.desafio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import relaciones.desafio1.model.Direccion;
import relaciones.desafio1.service.DireccionService;

@Controller
@RequestMapping("direccion")
public class DireccionController {

    @Autowired
    private DireccionService servDireccion;
    
	@GetMapping("/crear")
	public ModelAndView crearDireccion() {
		ModelAndView modelAndView = new ModelAndView("crear-direccion");
		modelAndView.addObject("direccion",new Direccion());
		return modelAndView;
	}
	
	@PostMapping("/creado")
	public ModelAndView crearPostDireccion(@ModelAttribute Direccion direccion) {
		ModelAndView modelAndView = new ModelAndView("direcciones");
		servDireccion.save(direccion);
		modelAndView.addObject("direcciones",servDireccion.findAll());
		return modelAndView;
	}
	
	@GetMapping("/lista")
	public ModelAndView direcciones() {
		ModelAndView modelAndView = new ModelAndView("direcciones");
		modelAndView.addObject("direcciones", servDireccion.findAll());
		return modelAndView;
	}
}
