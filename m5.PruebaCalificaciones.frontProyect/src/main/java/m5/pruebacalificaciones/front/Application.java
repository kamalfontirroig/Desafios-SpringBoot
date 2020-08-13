package m5.pruebacalificaciones.front;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.expression.Lists;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.annotations.SerializedName;

import m5.pruebacalificaciones.front.dto.UserDTO;
import m5.pruebacalificaciones.front.service.RandomName;

@SpringBootApplication
public class Application implements Serializable{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    System.out.println("hello world, I have just started up");
	    
	    HttpHeaders headers = new HttpHeaders();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Map<String, Object> princi= (Map<String, Object>) auth.getPrincipal();
//		headers.setBearerAuth(princi.get("token").toString()); 
		headers.setContentType(MediaType.APPLICATION_JSON);
		ArrayList<String> roles = new ArrayList<>(Arrays.asList("ROLE_ADMIN"));
		 JSONObject userJsonObject = new JSONObject();
		    userJsonObject.put("username", "admin");
		    userJsonObject.put("password", "admin");
		    userJsonObject.put("roles", roles);
		    HttpEntity<String> request = new HttpEntity<String>(userJsonObject.toJSONString(),headers);
		    String resultado = restTemplate.postForObject("http://localhost:8080/v1/users/signup", request, String.class);
		    
		    UserDTO user = new UserDTO("kamal", "kamal", Arrays.asList("ROLE_ADMIN") );
		    
		    
		 
		    JsonMapper mapper = new JsonMapper();
		    
		    try {
				
			    request = new HttpEntity<String>(mapper.writeValueAsString(user),headers);
			    resultado = restTemplate.postForObject("http://localhost:8080/v1/users/signup", request, String.class);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
