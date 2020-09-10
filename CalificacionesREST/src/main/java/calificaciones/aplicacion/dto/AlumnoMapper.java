package calificaciones.aplicacion.dto;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import calificaciones.aplicacion.modelos.Alumno;
import calificaciones.aplicacion.modelos.Materia;

public class AlumnoMapper {

	//DTO a entity
	private static void toEntity(AlumnoDTO alumnoDTO, Alumno alumno) {
		alumno.setId(alumnoDTO.getId());
		alumno.setDireccion(alumnoDTO.getDireccion());
		alumno.setRut(alumnoDTO.getRut());
		alumno.setNombre(alumnoDTO.getNombre());
		alumno.setMateriaList((alumnoDTO.getMateriaList() != null)? alumnoDTO.getMateriaList(): new ArrayList<Materia>()); //alumnoDTO.getMateriaList().stream().map(MateriaMapper::toEntity).collect(Collectors.toList()): new ArrayList<Materia>()
	}
	
	@SuppressWarnings("unused")
	public static Alumno toEntity(AlumnoDTO alumnoDTO) {
		Alumno alumno = new Alumno();
		toEntity(alumnoDTO, alumno);
		return alumno;
	}
}
