package calificaciones.aplicacion.modelos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import calificaciones.aplicacion.dto.AlumnoDTO;
import calificaciones.aplicacion.dto.MateriaDTO;
import calificaciones.aplicacion.dto.MateriaMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String rut; 
		private String  nombre;
		private String  direccion;
			
		@JsonManagedReference
		@OneToMany(mappedBy = "alumno")
		private List<Materia> materiaList;
		
		public AlumnoDTO toDTO() {
			return new AlumnoDTO(this.id, this.rut , this.nombre, this.direccion, this.materiaList ); //this.materiaList.stream().map(Materia::toDTO).collect(Collectors.toList())
		
		}
}
