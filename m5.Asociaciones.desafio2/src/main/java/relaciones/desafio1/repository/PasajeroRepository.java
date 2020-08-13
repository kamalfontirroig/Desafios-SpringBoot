package relaciones.desafio1.repository;

import org.springframework.data.repository.CrudRepository;

import relaciones.desafio1.model.Pasajero;

public interface PasajeroRepository extends CrudRepository<Pasajero, Long> {

}
