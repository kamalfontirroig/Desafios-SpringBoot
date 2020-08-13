package relaciones.desafio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import relaciones.desafio1.model.Alumno;
import relaciones.desafio1.service.AlumnoService;
import relaciones.desafio1.service.DireccionService;

@Controller
@RequestMapping(value={"alumno",""})
public class AlumnoController {

	@Autowired
	DireccionService servDireccion;
	
	@Autowired
	AlumnoService servAlumno;
	
	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView modelAndView = new ModelAndView("crear-alumno");
        modelAndView.addObject("alumno", new Alumno());
		modelAndView.addObject("direcciones",servDireccion.findAll());
		return modelAndView;
	}
	
	@PostMapping("/creado")
	public ModelAndView crearPost(@ModelAttribute Alumno alumno) {
		servAlumno.save(alumno);
		ModelAndView modelAndView = new ModelAndView("alumnos");
		modelAndView.addObject("alumnos", servAlumno.findAll());
		return modelAndView;
	}
	
	@GetMapping(value={"lista",""})
	public ModelAndView alumnos() {
		ModelAndView modelAndView = new ModelAndView("alumnos");
		modelAndView.addObject("alumnos", servAlumno.findAll());
		return modelAndView;
	}
}
