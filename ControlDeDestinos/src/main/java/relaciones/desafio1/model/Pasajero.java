package relaciones.desafio1.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pasajero {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String rut;
	private String nombre;
	private String apellido;
	private int edad;
	private String ciudadNatal;
	@OneToMany(mappedBy = "pasajero")
	private List<Destino> destinos;
	
	@Override
	public String toString() {
		return this.nombre + " " + this.apellido;
	}
	
	
}
