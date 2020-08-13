package relaciones.desafio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import relaciones.desafio1.model.Alumno;
import relaciones.desafio1.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository dao;
	
	@Override
	public void save(Alumno alumno) {
		dao.save(alumno);
	}

	@Override
	public List<Alumno> findAll() {
		ArrayList<Alumno> listaVacia = new ArrayList<Alumno>();
		return (dao.findAll() != null)? (List<Alumno>) dao.findAll():listaVacia;
	}

}
