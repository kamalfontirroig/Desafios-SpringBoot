package stocker.services;

import org.springframework.data.domain.Pageable;


import stocker.model.Producto;
import stocker.vo.ProductoVo;

public interface ProductoService {
	
	//C
	public ProductoVo insertarProducto(Producto producto);
	//R
	public ProductoVo getByNombre(String textoBuscado);
	public ProductoVo getAllByNombre(String textoBuscado) ;
	public ProductoVo getAllByNombre(String textoBuscado, Pageable pageable);
	public ProductoVo getAll();
	public ProductoVo getById(int id);
	//U
	public ProductoVo modificarProducto(Producto producto);	
	//D
	public ProductoVo deleteProducto(Producto producto);
	
	//Utilidades
	public long cantidadDePaginas(long cantidadPorPagina);
	public long cantidadDePaginas(long cantidadPorPagina, int count);
	
}
