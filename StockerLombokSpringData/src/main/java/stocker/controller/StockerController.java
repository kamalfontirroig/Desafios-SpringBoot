package stocker.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import stocker.model.Producto;
import stocker.services.ProductoService;
import stocker.vo.ProductoVo;

@Controller
@RequestMapping("/")
public class StockerController {
	
	@Autowired
	ProductoService service;
	
	@Autowired
	ProductoVo respuesta;
	
	String textoBuscadoAux = "";
	
	int paginaAux = 0;
	int cantidadPorPaginaAux = 10;
	int paginasAux = 0;
	
	@RequestMapping("")
	public String home(ModelMap model) {
		//service.insertarProducto(new Producto(null, "Cola", 1000, 10));
//		respuesta = service.getAllByNombre(textoBuscadoAux);
//		if (respuesta.getCodigo() == 200) {
//			model.addAttribute("listaProducto", respuesta.getListaProductos());
//			return "home";
//		} else {
//			return "home";
//		}
//		System.out.println("c10 r1 rpp"+service.cantidadDePaginas(1,10));
//		System.out.println("c10 r5 rpp"+service.cantidadDePaginas(5,10));
//		System.out.println("c10 r7 rpp"+service.cantidadDePaginas(7,10));
//		System.out.println("c10 r8 rpp"+service.cantidadDePaginas(8,10));
//		System.out.println("c10 r10 rpp"+service.cantidadDePaginas(10,10));
//		System.out.println("c10 r16 rpp"+service.cantidadDePaginas(16,10));
//		System.out.println("c10 r31 rpp"+service.cantidadDePaginas(31,10));
//		
//		
		model.addAttribute("textoBuscado", textoBuscadoAux);
		return "home";
		
	}
	
	@RequestMapping("/buscar")
	public String buscar(ModelMap model, @RequestParam("textoBuscado") String textoBuscado, 
			@RequestParam(value="cantidadPorPagina", defaultValue = "10") int cantidadPorPagina, 
			@RequestParam(value = "pagina", defaultValue = "0") int pagina) {
		
		nullifyAttributes(model);
		respuesta = service.getAllByNombre(textoBuscado);
		
		respuesta.setListaProductos(paginacion(model, textoBuscado, cantidadPorPagina, pagina));
			
		textoBuscadoAux = textoBuscado;
		model.addAttribute("textoBuscado", textoBuscadoAux);
		if (respuesta.getCodigo() == 200) {
			model.addAttribute("listaProductos", respuesta.getListaProductos());
			model.addAttribute("mensaje", respuesta.getMensaje());
			return "home";
		} else {
			model.addAttribute("error", respuesta.getMensaje());
			return "home";
		}
	}



	//AGREGAR PRODUCTO
	@RequestMapping("/addForm")
	public String formaDeRegistro(ModelMap model) {
		nullifyAttributes(model);
		
		model.addAttribute("modoRegistrar", "registrar");
		model.addAttribute("textoBuscado", textoBuscadoAux);
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(ModelMap model, @ModelAttribute("producto") Producto producto) {
		nullifyAttributes(model);
		
		respuesta = service.insertarProducto(producto);
		respuesta.setListaProductos(paginacion(model, textoBuscadoAux, cantidadPorPaginaAux, paginaAux));
		
		model.addAttribute("paginaM", paginaAux);
		model.addAttribute("textoBuscado", textoBuscadoAux);
		
		if (respuesta.getCodigo() == 200) {
			model.addAttribute("producto", respuesta.getProducto());
			model.addAttribute("listaProductos", respuesta.getListaProductos());
			model.addAttribute("mensaje", respuesta.getMensaje());
			return "home";
		} else {
			model.addAttribute("error", respuesta.getMensaje());
			model.addAttribute("producto", producto);
			model.addAttribute("listaProductos", respuesta.getListaProductos());
		
			return "home";
		}
	}
	//AGREGAR END
	
	//MODIFICAR 
	@RequestMapping("/modificarForm")
	public String formaDeActualizcion(ModelMap model, @RequestParam("id") int id) {
		nullifyAttributes(model);
		
		model.addAttribute("producto", service.getById(id).getProducto()); //no necesita verificacion
		model.addAttribute("modoActualizar", "actualizacion");
		model.addAttribute("textoBuscado", textoBuscadoAux);
		
		return "home";
	}
	
	@RequestMapping("/modificar")
	public String actualizar(ModelMap model,@ModelAttribute("producto") Producto producto) {
		nullifyAttributes(model);
		
		respuesta = service.modificarProducto(producto);
		respuesta.setListaProductos(paginacion(model, textoBuscadoAux, cantidadPorPaginaAux, paginaAux));

		model.addAttribute("paginaM", paginaAux);
		model.addAttribute("textoBuscado", textoBuscadoAux);
		
		if (respuesta.getCodigo() == 200) {
			model.addAttribute("producto", respuesta.getProducto());
			model.addAttribute("listaProductos", respuesta.getListaProductos());
			model.addAttribute("mensaje", respuesta.getMensaje());
			return "home";
		} else {
			model.addAttribute("error", respuesta.getMensaje());
			model.addAttribute("producto", respuesta.getProducto());
			model.addAttribute("listaProductos", respuesta.getListaProductos());
		
			return "home";
		}
	}
	
	@RequestMapping("/borrar")
	public String borrar(ModelMap model, @RequestParam("id") int id) {
		respuesta = service.deleteProducto(service.getById(id).getProducto());
		respuesta.setListaProductos(paginacion(model, textoBuscadoAux, cantidadPorPaginaAux, paginaAux));

		model.addAttribute("paginaM", paginaAux);
		model.addAttribute("textoBuscado", textoBuscadoAux);
		
		if (respuesta.getCodigo() == 200) {
			model.addAttribute("producto", respuesta.getProducto());
			model.addAttribute("listaProductos", respuesta.getListaProductos());
			model.addAttribute("mensaje", respuesta.getMensaje());
			return "home";
		} else {
			model.addAttribute("error", respuesta.getMensaje());
			model.addAttribute("producto", respuesta.getProducto());
			model.addAttribute("listaProductos", respuesta.getListaProductos());
		
			return "home";
		}
	}
	
	private ArrayList<Producto> paginacion(ModelMap model, String textoBuscado, int cantidadPorPagina, int pagina) {
		//Paginacion
		Pageable pageable = PageRequest.of(pagina, cantidadPorPagina);
	
		
		model.addAttribute("paginas", service.cantidadDePaginas(cantidadPorPagina, (service.getAllByNombre(textoBuscado).getListaProductos()==null)?0:service.getAllByNombre(textoBuscado).getListaProductos().size()));
		model.addAttribute("pagina", pagina);
		model.addAttribute("cantidadPorPagina", cantidadPorPagina);
		//
		
		return 	(ArrayList<Producto>) service.getAllByNombre(textoBuscado, pageable).getListaProductos();
	}
	
	private void nullifyAttributes(ModelMap model) {
		model.addAttribute("error", null);
		model.addAttribute("listaProductos", null);
		model.addAttribute("producto", null);
		model.addAttribute("modoActualizar",null);
	}
	
	private void nullifyAttributesKeepProductList(ModelMap model) {
		model.addAttribute("error", null);
		model.addAttribute("producto", null);
		model.addAttribute("modoActualizar",null);
	}
}
