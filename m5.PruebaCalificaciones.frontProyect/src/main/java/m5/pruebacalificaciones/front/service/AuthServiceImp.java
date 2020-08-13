package m5.pruebacalificaciones.front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import m5.pruebacalificaciones.front.dto.UserDTO;

@Service
public class AuthServiceImp implements AuthService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${endpoint.root}${endpoint.userroot}${endpoint.usersignin}")
	String signinEndpoint;
	
	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity signin(String username, String password) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		HttpEntity<UserDTO> request = new HttpEntity<>(userDTO);
		
		return restTemplate.postForEntity(signinEndpoint, request, String.class);
	}
}