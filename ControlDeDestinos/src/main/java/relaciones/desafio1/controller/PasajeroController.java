package relaciones.desafio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import relaciones.desafio1.model.Destino;
import relaciones.desafio1.model.Pasajero;
import relaciones.desafio1.service.PasajeroService;
import relaciones.desafio1.service.DestinoService;

@Controller
@RequestMapping(value={"pasajero",""})
public class PasajeroController {

	@Autowired
	PasajeroService servPasajero;
	
	@Autowired
	DestinoService servDestino;
	
	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView modelAndView = new ModelAndView("crear-pasajero");
        modelAndView.addObject("pasajero", new Pasajero());
		return modelAndView;
	}
	
	@PostMapping("/creado")
	public ModelAndView crearPost(@ModelAttribute Pasajero pasajero) {

		servPasajero.save(pasajero);
		ModelAndView modelAndView = new ModelAndView("pasajeros");
		modelAndView.addObject("pasajeros", servPasajero.findAll());
		return modelAndView;
	}
	
	@GetMapping(value={"/lista",""})
	public ModelAndView pasajeros() {
		ModelAndView modelAndView = new ModelAndView("pasajeros");
		modelAndView.addObject("pasajeros", servPasajero.findAll());
		return modelAndView;
	}
}

