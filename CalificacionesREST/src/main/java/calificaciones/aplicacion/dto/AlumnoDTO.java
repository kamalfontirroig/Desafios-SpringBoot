package calificaciones.aplicacion.dto;

import java.util.List;

import calificaciones.aplicacion.modelos.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {

		private Long id;
		private String rut; 
		private String  nombre;
		private String  direccion;
		private List<Materia> materiaList;
}