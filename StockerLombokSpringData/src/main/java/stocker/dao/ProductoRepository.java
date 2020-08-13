package stocker.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import stocker.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto,Integer>{

	//Declarar los metodos con esta estructura:
	//@Query("la query que quiero hacer con comodines: ?1 ?2  ?3 ... ")
	//public TipoDeRetorno nombreDeMetodo(Argumentos en orden de los comodines);
	//luego Spring implementara el metodo.
	
	@Query(value ="SELECT codigo, nombre, precio, stock FROM Producto WHERE nombre = ?1", nativeQuery= true)
	public Producto getByNombre(String nombre);
	
	
	
	
	
	
	@Query(value="SELECT codigo, nombre, precio, stock FROM Producto WHERE regexp_like(nombre, ?1, 'i')",
			countQuery = "SELECT count(*) Producto WHERE regexp_like(nombre, ?1, 'i')",
			nativeQuery= true) 
	public List<Producto> getAllByNombre(String textoBuscado, Pageable pageable);
	
	
	
	
	@Query(value="SELECT codigo, nombre, precio, stock FROM Producto WHERE regexp_like(nombre, ?1, 'i')",
			nativeQuery= true) 
	public List<Producto> getAllByNombre(String textoBuscado);
	
	@Query("SELECT codigo, nombre, precio, stock FROM Producto")
	public List<Producto> getAll();

	@Query(value ="SELECT * FROM Producto WHERE codigo = ?1", nativeQuery = true)
	public Producto getById(int id);
	
	
//	@Query(value ="UPDATE Producto SET nombre = ?1, precio = ?2, stock = ?3 WHERE codigo = ?4", nativeQuery= true)
//	public void update(String nombre, double precio, int stock, int codigo);
//  	Esta query la crea automaticamente SPRING JPA ****dao.save(Producto)****
	
	
//	@Query(value="INSERT INTO Producto (nombre, precio, stock) values (?1, ?2, ?3)", nativeQuery= true)
//	public void insertarProducto(String nombre, double precio, int stock);
//	    Esta query la crea automaticamente SPRING JPA ****dao.save(Producto);****
	
}
