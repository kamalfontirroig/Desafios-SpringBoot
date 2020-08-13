package m5.pruebacalificaciones.front.service;

import org.springframework.http.ResponseEntity;

public interface AuthService {

	ResponseEntity signin(String username, String password);

}
