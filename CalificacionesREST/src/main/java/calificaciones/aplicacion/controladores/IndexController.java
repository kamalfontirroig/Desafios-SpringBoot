package calificaciones.aplicacion.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import calificaciones.aplicacion.modelos.Alumno;
import calificaciones.aplicacion.modelos.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("")
public class IndexController {
	
	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	public class Endpoints{
		private String url;
		private String metodo;
		private Object jsonRequestBody;
		private Object JsonResponseBody;
		private String info;
	}
	
	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	public class Materia1{
		private String nombre;
	}
	
	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	public class Materia2{
		private Long id;
		private String nombre;
	}
	
	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	public class Alumno1{
		private String rut;
		private String nombre;
		private String direccion;
	}
	
	@GetMapping("/")
	public List<Endpoints> listEndpoints(){
		ArrayList<Endpoints> endpointsList = new ArrayList<IndexController.Endpoints>();
		List<Object> list =  new ArrayList<Object>();
		list.add(new Alumno((long) 1, "rut", "nombre", "direccion", new ArrayList()));
		endpointsList.add(new Endpoints("/v1/alumnos/nuevo","POST",  new Alumno1("rut", "nombre", "direccion"), null, "Crea un nuevo alumno a partir de BodyRequest. No se creara si el rut ya se encuentra registrado"));
		endpointsList.add(new Endpoints( "/v1/alumnos/{rut}/materias/nueva", "POST", new Materia1("nombre"), null, "Crea una nueva materia en el alumno del {rut} entregado. Solo se creara si existe un alumno con ese rut"));
		endpointsList.add( ( new Endpoints("/v1/alumnos", "GET", null , list , "Se obtiene la lista completa de alumnos y sus materias agregadas") )  );
		endpointsList.add(new Endpoints("/v1/alumnos/{rut}","GET", null, new Alumno((long) 1, "rut", "nombre", "direccion", new ArrayList()), "Se obtiene un alumno por su {rut} con sus materias agregadas" ));
		list.remove(0);
		list.add(new Materia2((long) 1, "nombre"));
		endpointsList.add(new Endpoints("/v1/alumnos/{rut}/materias", "GET", null, list, "Se lista las materias del alumno de {rut}"  )   );
		
		
		return endpointsList;
		
	}

}
