package calificaciones.aplicacion.servicios;

import calificaciones.aplicacion.dto.MateriaDTO;

public interface IMateriaServicio {

	public void create(MateriaDTO materiaDTO, String rut);
}
