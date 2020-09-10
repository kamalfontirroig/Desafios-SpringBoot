package m5.pruebacalificaciones.front.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnosDTO {

		private Long id;
		private String rut; 
		private String  nombre;
		private String  direccion;
		private List<MateriaDTO> materiaList;
}