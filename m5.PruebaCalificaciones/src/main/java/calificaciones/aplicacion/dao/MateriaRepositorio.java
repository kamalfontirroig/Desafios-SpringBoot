package calificaciones.aplicacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import calificaciones.aplicacion.modelos.Materia;

public interface MateriaRepositorio extends JpaRepository<Materia, Long>{

	
}
