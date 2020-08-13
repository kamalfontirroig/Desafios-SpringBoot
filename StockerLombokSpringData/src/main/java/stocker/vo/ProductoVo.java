package stocker.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stocker.model.Producto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductoVo {

	@Autowired
	private Producto producto;
	
	@Autowired
	private List<Producto> listaProductos;
	
	private String mensaje;
	private int codigo;
}
