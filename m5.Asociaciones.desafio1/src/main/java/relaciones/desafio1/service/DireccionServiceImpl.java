package relaciones.desafio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import relaciones.desafio1.model.Direccion;
import relaciones.desafio1.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	DireccionRepository dao;
	
	@Override
	public void save(Direccion direccion) {
	dao.save(direccion);
	}

	@Override
	public List<Direccion> findAll() {
		ArrayList<Direccion> listaVacia = new ArrayList<Direccion>();
		return (dao.findAll() != null)?(List<Direccion>) dao.findAll():listaVacia;
	}

}
