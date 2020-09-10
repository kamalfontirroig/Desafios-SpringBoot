package calificaciones.aplicacion.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calificaciones.aplicacion.dao.AlumnoRepositorio;
import calificaciones.aplicacion.dto.AlumnoDTO;
import calificaciones.aplicacion.dto.AlumnoMapper;
import calificaciones.aplicacion.modelos.Alumno;

@Service
public class AlumnoServicioImp  implements IAlumnoServicio{

	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	
	@Override
	public void create(AlumnoDTO alumnoDTO) {
	if (alumnoRepositorio.findByRut(alumnoDTO.getRut()) == null) {
		alumnoRepositorio.save(AlumnoMapper.toEntity(alumnoDTO));
	}
	}

	@Override
	public AlumnoDTO findByRut(String rut) {
		Alumno alumno = alumnoRepositorio.findByRut(rut);
		if (alumno !=null) {
		return alumnoRepositorio.findByRut(rut).toDTO();
		}
		return null;
	}

	@Override
	public List<AlumnoDTO> findAll() {
		return alumnoRepositorio.findAll().stream().map(Alumno::toDTO).collect(Collectors.toList());
	}

}
