package cl.desafiolatam.contactmanager.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.contactmanager.model.Contact;
import cl.desafiolatam.contactmanager.servicios.ContactoServicio;

@Component
public class ContactoServicioImpl implements ContactoServicio {
	
	static int newId;
	
	ArrayList<Contact> listaContactos;
	
	
	public ContactoServicioImpl() {
		
		this.listaContactos = new ArrayList<Contact>();
	}

	
	@Override
	public List<Contact> getContactList() {
		
		listaContactos.removeIf(contacto -> contacto.getIdContact()<=0);
		return listaContactos;
	}

	
	@Override
	public List<Contact> addContact(Contact contact) {
		
		listaContactos.removeIf(contacto -> contacto.getIdContact()<=0);
		
		newId  = 1;
		while (listaContactos.stream().anyMatch(contacto -> contacto.getIdContact() == newId)) {
		newId++;
		}
		
		contact.setIdContact(newId);
		listaContactos.add(contact);
		return listaContactos;
	}

	
	@Override
	public List<Contact> deleteContact(int id) {
		
		listaContactos.removeIf(contacto -> contacto.getIdContact() == id);
		return listaContactos;
	}

}
