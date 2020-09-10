package stocker.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import stocker.dao.ProductoRepository;
import stocker.model.Producto;
import stocker.vo.ProductoVo;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository dao;
	
	//C.
	@Override
	public ProductoVo insertarProducto(Producto producto) {
		ProductoVo vo = new ProductoVo();
		if (dao.getByNombre(producto.getNombre()) == null) {
			dao.save(producto);
			vo.setProducto(producto);
			vo.setMensaje("Producto insertado");
			vo.setCodigo(200);
			vo.setListaProductos(null);
		} else {
			vo.setMensaje("Producto/s NO encontrado/s");
			vo.setCodigo(500);
			vo.setListaProductos(null);
			vo.setProducto(null);
		}

		return vo;
	}
	//R.1
	public ProductoVo getAllByNombre(String textoBuscado) {
		ProductoVo vo = new ProductoVo();
		vo.setListaProductos(dao.getAllByNombre(textoBuscado));
		if (vo.getListaProductos().size() > 0) {
			vo.setMensaje("Producto/s encontrado/s");
			vo.setCodigo(200);
			vo.setProducto(vo.getListaProductos().get(0));
		} else {
			vo.setMensaje("Producto/s NO encontrado/s");
			vo.setCodigo(500);
			vo.setListaProductos(null);
			vo.setProducto(null);
		}

		return vo;

	}
	//R.1 Sobrecarcado para paginacion
	public ProductoVo getAllByNombre(String textoBuscado, Pageable pageable) {
		ProductoVo vo = new ProductoVo();
		vo.setListaProductos(dao.getAllByNombre(textoBuscado, pageable));
		
		if (vo.getListaProductos().size() > 0) {
			vo.setMensaje("Producto/s encontrado/s");
			vo.setCodigo(200);
			vo.setProducto(vo.getListaProductos().get(0));
		} else {
			vo.setMensaje("Producto/s NO encontrado/s");
			vo.setCodigo(500);
			vo.setListaProductos(null);
			vo.setProducto(null);
		}

		return vo;

	}
    //R.2
	@Override
	public ProductoVo getAll() {
		ProductoVo vo = new ProductoVo();
		vo.setListaProductos(dao.getAll());
		if (vo.getListaProductos().size() > 0) {
			vo.setMensaje("Producto/s encontrado/s");
			vo.setCodigo(200);
			vo.setProducto(vo.getListaProductos().get(0));
		} else {
			vo.setMensaje("Producto/s NO encontrado/s");
			vo.setCodigo(500);
			vo.setListaProductos(null);
			vo.setProducto(null);
		}

		return vo;
	}
	
	//R.3
	public ProductoVo getByNombre(String textoBuscado) {
		ProductoVo vo = new ProductoVo();
		vo.setProducto(dao.getByNombre(textoBuscado));
		if (vo.getProducto() != null) {
			vo.setMensaje("Producto encontrado");
			vo.setCodigo(200);
			vo.setListaProductos(null);
		} else {
			vo.setMensaje("Producto NO encontrado");
			vo.setCodigo(500);
			vo.setListaProductos(null);
			vo.setProducto(null);
		}

		return vo;

	}
	//R.4
	public ProductoVo getById(int id) {
		ProductoVo vo = new ProductoVo();
		vo.setProducto(dao.getById(id));
		if (vo.getProducto() != null) {
			vo.setMensaje("Producto encontrado");
			vo.setCodigo(200);
			vo.setListaProductos(null);
		} else {
			vo.setMensaje("Producto NO encontrado");
			vo.setCodigo(500);
			vo.setListaProductos(null);
			vo.setProducto(null);
		}

		return vo;

	}
	//U
	public ProductoVo modificarProducto(Producto producto) {
		ProductoVo vo = new ProductoVo();
		if (dao.existsById(producto.getCodigo()) && dao.getByNombre(producto.getNombre()) == null ) {
			dao.save(producto);
			vo.setProducto(producto);
			vo.setListaProductos(null);
			vo.setMensaje("Producto actualizado");
			vo.setCodigo(200);
		} else {
			vo.setProducto(producto);
			vo.setListaProductos(null);
			vo.setMensaje("Producto no pudo ser actualizado");
			vo.setCodigo(500);
		}

		return vo;
	}

    //D
	public ProductoVo deleteProducto(Producto producto) {
		ProductoVo vo = new ProductoVo();
		if (producto!=null && dao.existsById(producto.getCodigo())) {
			dao.deleteById(producto.getCodigo());
			vo.setProducto(null);
			vo.setListaProductos(null);
			vo.setMensaje("Producto Eliminado");
			vo.setCodigo(200);
		} else {
			vo.setProducto(producto);
			vo.setListaProductos(null);
			vo.setMensaje("Producto no pudo ser eliminado");
			vo.setCodigo(500);
		}

		return vo;

	}

	//Contador paginas
	public long cantidadDePaginas(long cantidadPorPagina, int count) {
		long totalRegistros = count; //dao.count();
		long cantidadDePaginas= totalRegistros/cantidadPorPagina + ((totalRegistros%cantidadPorPagina == 0)?0:1);
		return cantidadDePaginas;
		
		
	}
	@Override
	public long cantidadDePaginas(long cantidadPorPagina) {
		// TODO Auto-generated method stub
		return 0;
	}

}
