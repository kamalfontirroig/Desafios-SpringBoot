package calificaciones.aplicacion.servicios;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calificaciones.aplicacion.dao.AlumnoRepositorio;
import calificaciones.aplicacion.dao.MateriaRepositorio;
import calificaciones.aplicacion.dto.AlumnoDTO;
import calificaciones.aplicacion.dto.MateriaDTO;
import calificaciones.aplicacion.dto.MateriaMapper;
import calificaciones.aplicacion.modelos.Alumno;


@Service
public class MateriaServicioImp implements IMateriaServicio {

	@Autowired
	MateriaRepositorio materiaRepositorio;
	
	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	@Override
	public void create(MateriaDTO materiaDTO, String rut) {
		Alumno alumno = alumnoRepositorio.findByRut(rut);
		if (alumno != null) {
		materiaDTO.setAlumno(alumno);
		materiaRepositorio. save(MateriaMapper.toEntity(materiaDTO));
		}		
	}

	
}
