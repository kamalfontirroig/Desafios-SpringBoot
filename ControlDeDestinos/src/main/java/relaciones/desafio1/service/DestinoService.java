package relaciones.desafio1.service;

import java.util.List;

import relaciones.desafio1.model.Destino;

public interface DestinoService {

	public void save(Destino direccion);
	public List<Destino> findAll();

}
