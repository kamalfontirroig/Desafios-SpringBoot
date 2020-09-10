package calificaciones.aplicacion.servicios;

import calificaciones.aplicacion.modelos.User;

public interface UserService {
	String signin(User user);

	String signup(User user);
}
