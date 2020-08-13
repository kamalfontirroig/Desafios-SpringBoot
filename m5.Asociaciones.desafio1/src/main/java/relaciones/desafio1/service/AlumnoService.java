package relaciones.desafio1.service;

import java.util.List;

import relaciones.desafio1.model.Alumno;

public interface AlumnoService {
	
	public void save(Alumno alumno);
	public List<Alumno> findAll();

}
