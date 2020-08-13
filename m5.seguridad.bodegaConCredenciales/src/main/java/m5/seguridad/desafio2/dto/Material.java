package m5.seguridad.desafio2.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Material {

	private Long precio; 
	private String nombre;
	private Bodega bodega;
	private Date fechaIngreso;
	
	public Material(){
		this.fechaIngreso = new Date();
	}
	
	
}
