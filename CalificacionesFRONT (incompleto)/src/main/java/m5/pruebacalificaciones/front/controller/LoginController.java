package m5.pruebacalificaciones.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import m5.pruebacalificaciones.front.dto.AlumnosDTO;
import m5.pruebacalificaciones.front.service.RandomName;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/login" })
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@GetMapping("/populate")
//	public ModelAndView populate() {
//		AlumnosDTO alumnosDTO = new AlumnosDTO();
//		HttpHeaders headers = new HttpHeaders();
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Map<String, Object> princi= (Map<String, Object>) auth.getPrincipal();
//		headers.setBearerAuth(princi.get("token").toString()); 
//		
//		MultiValueMap<String, String> alumnoMap = new LinkedMultiValueMap<String, String>();
//
//		alumnoMap.add("nombre", "kamal");
//		alumnoMap.add("direccion", "Sucasa");
//		HttpEntity<MultiValueMap<String, String> > request = new HttpEntity<MultiValueMap<String, String>>(alumnoMap,headers);
//		ResponseEntity<Object> response = restTemplate.exchange("http://localhost:8080/v1/alumnos/nuevo", HttpMethod.POST, request, new ParameterizedTypeReference<Object>(){});
//		
//		return new ModelAndView("/");
//	}
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/populate")
	public ModelAndView populate() {
		HttpHeaders headers = new HttpHeaders();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> princi= (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(princi.get("token").toString()); 
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String nombreAzar = RandomName.randomName();
		String rutAzar = String.valueOf((int) (Math.random()*1000));
		 JSONObject alumnoJsonObject = new JSONObject();
		    alumnoJsonObject.put("id", 999);
		    alumnoJsonObject.put("nombre", nombreAzar);
		    alumnoJsonObject.put("direccion", "Casa");
		    alumnoJsonObject.put("rut", rutAzar );
		    
		    HttpEntity<String> request = new HttpEntity<String>(alumnoJsonObject.toJSONString(),headers);
		    String resultado = restTemplate.postForObject("http://localhost:8080/v1/alumnos/nuevo", request, String.class);
		    
		    
		   float iteraciones = (float) (Math.random()*10);
		    System.out.println((int) iteraciones);
		    for (int i=0; i<(int)iteraciones; i++) {
		    JSONObject materiaJsonObject= new JSONObject();	
		    materiaJsonObject.put("nombre", "Materia_"+i);
		    request = new HttpEntity<String>(materiaJsonObject.toJSONString(), headers);
		    resultado = restTemplate.postForObject("http://localhost:8080/v1/alumnos/"+rutAzar+"/materias/nueva", request, String.class);
		    }
		    
		return new ModelAndView("populated");
	}
}
