package calificaciones.aplicacion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import calificaciones.aplicacion.dto.AlumnoDTO;
import calificaciones.aplicacion.dto.MateriaDTO;
import calificaciones.aplicacion.modelos.Materia;
import calificaciones.aplicacion.servicios.IAlumnoServicio;
import calificaciones.aplicacion.servicios.IMateriaServicio;

@RestController
@RequestMapping("/v1/alumnos")
public class MateriaControlador {

	@Autowired
	IMateriaServicio materiaServicio;

	@Autowired
	IAlumnoServicio alumnoServicio;

	@PostMapping("/{rut}/materias/nueva")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void createMateria(@PathVariable String rut, @RequestBody MateriaDTO materiaDTO) {

		materiaServicio.create(materiaDTO, rut);
	}

	@GetMapping("/{rut}/materias")
	@ResponseStatus(HttpStatus.OK)
	public List<Materia> getAll(@PathVariable String rut) {
		AlumnoDTO alumno = alumnoServicio.findByRut(rut);
		return (alumno != null) ? alumno.getMateriaList() : null;

	}

}
