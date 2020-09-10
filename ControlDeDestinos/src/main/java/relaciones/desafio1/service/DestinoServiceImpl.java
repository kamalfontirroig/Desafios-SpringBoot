package relaciones.desafio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import relaciones.desafio1.model.Destino;
import relaciones.desafio1.repository.DestinoRepository;

@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	DestinoRepository dao;
	
	@Override
	public void save(Destino direccion) {
	dao.save(direccion);
	}

	@Override
	public List<Destino> findAll() {
		ArrayList<Destino> listaVacia = new ArrayList<Destino>();
		return (dao.findAll() != null)?(List<Destino>) dao.findAll():listaVacia;
	}

}
