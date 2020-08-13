package calificaciones.aplicacion.dto;



import calificaciones.aplicacion.modelos.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {

	private Long id;
	private String nombre;
	private Alumno alumno;
	
}
