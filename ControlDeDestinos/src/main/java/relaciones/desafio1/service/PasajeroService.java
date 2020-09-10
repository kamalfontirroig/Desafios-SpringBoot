package relaciones.desafio1.service;

import java.util.List;

import relaciones.desafio1.model.Pasajero;

public interface PasajeroService {
	
	public void save(Pasajero alumno);
	public List<Pasajero> findAll();

}
