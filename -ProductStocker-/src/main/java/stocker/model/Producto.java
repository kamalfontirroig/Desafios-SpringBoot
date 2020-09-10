package stocker.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@SequenceGenerator(name="Sq_Producto", initialValue=1,allocationSize=1,sequenceName="Sq_Producto")
public class Producto {

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Sq_Producto")
		private Integer codigo;
		
		private String nombre;
		private double precio;
		private int stock;
}
