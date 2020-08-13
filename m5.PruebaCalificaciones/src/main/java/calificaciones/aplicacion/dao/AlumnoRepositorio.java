package calificaciones.aplicacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import calificaciones.aplicacion.modelos.Alumno;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long>{
	
	public Alumno findByRut(String rut);

}
