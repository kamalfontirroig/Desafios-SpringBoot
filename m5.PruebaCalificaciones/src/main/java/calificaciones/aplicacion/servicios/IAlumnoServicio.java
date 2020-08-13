package calificaciones.aplicacion.servicios;

import java.util.List;

import calificaciones.aplicacion.dto.AlumnoDTO;

public interface IAlumnoServicio {

	public void create(AlumnoDTO alumnoDTO);
	
	public AlumnoDTO findByRut(String rut);
	
	public List<AlumnoDTO> findAll();
}
