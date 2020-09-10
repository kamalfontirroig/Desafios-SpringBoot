package relaciones.desafio1.service;

import java.util.List;

import relaciones.desafio1.model.Direccion;

public interface DireccionService {

	public void save(Direccion direccion);
	public List<Direccion> findAll();

}
