package relaciones.desafio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import relaciones.desafio1.model.Pasajero;
import relaciones.desafio1.repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService {

	@Autowired
	PasajeroRepository dao;
	
	@Override
	public void save(Pasajero alumno) {
		dao.save(alumno);
	}

	@Override
	public List<Pasajero> findAll() {
		ArrayList<Pasajero> listaVacia = new ArrayList<Pasajero>();
		return (dao.findAll() != null)? (List<Pasajero>) dao.findAll():listaVacia;
	}

}
