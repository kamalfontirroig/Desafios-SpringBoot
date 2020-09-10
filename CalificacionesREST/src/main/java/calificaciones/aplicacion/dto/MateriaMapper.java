package calificaciones.aplicacion.dto;

import calificaciones.aplicacion.modelos.Materia;
import lombok.NoArgsConstructor;


public class MateriaMapper {

	private static void toEntity(MateriaDTO materiaDTO , Materia materia) {
		materia.setId(materiaDTO.getId());
		materia.setNombre(materiaDTO.getNombre());
		materia.setAlumno(materiaDTO.getAlumno());
	}
	
	public static Materia toEntity(MateriaDTO materiaDTO) {
		Materia materia = new Materia();
		toEntity(materiaDTO, materia);
		return materia;
		}
}
