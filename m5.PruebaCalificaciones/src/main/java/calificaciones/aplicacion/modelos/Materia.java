package calificaciones.aplicacion.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import calificaciones.aplicacion.dto.MateriaDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;

	@JsonBackReference
	//@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Alumno alumno;
	
	public MateriaDTO toDTO() {
		return new MateriaDTO(this.getId(), this.getNombre(), this.getAlumno());
	}
	
}
