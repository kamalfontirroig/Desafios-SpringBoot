package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Contacto;

@Controller
@RequestMapping("/contactManager")
public class ControllerContact {
	
	@Autowired
	Contacto contacto;
	private ArrayList<Contacto> listaContactos;
	
	
	public ControllerContact() {
		super();
		 listaContactos = new ArrayList<Contacto>();
	}


	@RequestMapping("/")
	public String home(@ModelAttribute Contacto contacto, ModelMap model) {
		
	if (contacto.getNombre() != null) {
		contacto.setId(contacto.getNombre()+contacto.getApellido1()+contacto.getApellido2());
		listaContactos.add(contacto);
	}
		model.addAttribute("listaContactos",listaContactos);
		
		return "contactManager";
	}

	@RequestMapping("/borrarContacto")
	public String borrarContacto(@RequestParam("id") String id, ModelMap model) {
		listaContactos.removeIf(contacto -> contacto.getId().contentEquals(id));
		model.addAttribute("listaContactos",listaContactos);
		return "contactManager";
		
	}
}
