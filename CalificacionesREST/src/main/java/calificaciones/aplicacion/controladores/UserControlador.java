package calificaciones.aplicacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import calificaciones.aplicacion.modelos.User;
import calificaciones.aplicacion.servicios.UserService;

@RestController
@RequestMapping("${endpoint.userroot}")
public class UserControlador {
	@Autowired
	private UserService userService;

	@PostMapping("${endpoint.usersignin}")
	public String login(@RequestBody User user) {
		return userService.signin(user);
	}

	@PostMapping("${endpoint.usersignup}")
	@ResponseStatus(HttpStatus.CREATED)
	public String signup(@RequestBody User user) {
		return userService.signup(user);
	}
	
}