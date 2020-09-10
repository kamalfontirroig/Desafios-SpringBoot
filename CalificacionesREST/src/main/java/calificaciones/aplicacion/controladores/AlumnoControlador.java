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
import calificaciones.aplicacion.servicios.IAlumnoServicio;

@RestController
@RequestMapping("/v1/alumnos")
public class AlumnoControlador {

	@Autowired
	IAlumnoServicio alumnoServicio;
	
	@GetMapping("/{rut}")
	@ResponseStatus(HttpStatus.OK)
	public AlumnoDTO getByRut(@PathVariable String rut) {
		return alumnoServicio.findByRut(rut);
	}
	
	@GetMapping(value= {"/", ""})
	@ResponseStatus(HttpStatus.OK)
	public List<AlumnoDTO> getAll(){
		return alumnoServicio.findAll();
		
	}
	
	@PostMapping("/nuevo")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody AlumnoDTO alumnoDTO) {
		alumnoServicio.create(alumnoDTO);
	}
	
}
