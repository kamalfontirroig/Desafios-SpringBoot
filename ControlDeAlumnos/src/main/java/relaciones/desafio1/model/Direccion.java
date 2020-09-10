package relaciones.desafio1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum TipoDireccion {
	CASA, TRABAJO, OTRO
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String calle;
	private int numero;
	private String ciudad;
	private TipoDireccion tipo;
	
	@Override
	public String toString() {
		return this.tipo+": "+ this.calle + " " + this.numero + ", " + this.ciudad;
	}

}
