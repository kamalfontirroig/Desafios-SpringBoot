package calificaciones.aplicacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import calificaciones.aplicacion.modelos.User;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByUsername(String username);

	User findByUsername(String username);
}