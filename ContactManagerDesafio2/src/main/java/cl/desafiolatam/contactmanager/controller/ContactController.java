package cl.desafiolatam.contactmanager.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.desafiolatam.contactmanager.model.Contact;
import cl.desafiolatam.contactmanager.servicios.ContactoServicio;


@Controller
@ComponentScan("cl.desafiolatam.contactmanager.servicios.impl")
@RequestMapping(value="/contactManager")
public class ContactController {
  
	
	@Autowired
	ContactoServicio servicio;


	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getContactList(ModelMap model) {
		
		model.put("listContact", servicio.getContactList());
		return "contactManager";
	}
	
	
	@RequestMapping(value="/addContact", method = RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contact") Contact contact) {

		model.put("listContact", servicio.addContact(contact));
		return "contactManager";
	}
	
	
	@RequestMapping(value="/deleteContact", method = RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") int id) {
		
		model.put("listContact", servicio.deleteContact(id));
		return "contactManager";
	}
	
}
