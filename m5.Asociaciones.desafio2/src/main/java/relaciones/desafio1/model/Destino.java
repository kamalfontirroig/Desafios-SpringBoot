package relaciones.desafio1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ciudad;
	private String pais;
	private String fecha;
	@ManyToOne
	private Pasajero pasajero;
	

	
}
