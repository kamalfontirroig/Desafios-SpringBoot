package relaciones.desafio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import relaciones.desafio1.model.Destino;
import relaciones.desafio1.service.DestinoService;
import relaciones.desafio1.service.PasajeroService;

@Controller
@RequestMapping("destino")
public class DestinoController {

    @Autowired
    private DestinoService servDestino;
    
	@Autowired
	PasajeroService servPasajero;
    
	@GetMapping("/crear")
	public ModelAndView crearDireccion() {
		ModelAndView modelAndView = new ModelAndView("crear-destino");
		modelAndView.addObject("destino",new Destino());
		modelAndView.addObject("pasajeros", servPasajero.findAll());
		return modelAndView;
	}
	
	@PostMapping("/creado")
	public ModelAndView crearPostDireccion(@ModelAttribute Destino destino) {
		ModelAndView modelAndView = new ModelAndView("destinos");
		servDestino.save(destino);
		modelAndView.addObject("destinos",servDestino.findAll());
		return modelAndView;
	}
	
	@GetMapping("/lista")
	public ModelAndView destinos() {
		ModelAndView modelAndView = new ModelAndView("destinos");
		modelAndView.addObject("destinos", servDestino.findAll());
		return modelAndView;
	}
}
