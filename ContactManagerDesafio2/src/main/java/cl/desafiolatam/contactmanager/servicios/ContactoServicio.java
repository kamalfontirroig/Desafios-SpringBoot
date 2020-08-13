package cl.desafiolatam.contactmanager.servicios;

import java.util.List;

import cl.desafiolatam.contactmanager.model.Contact;

public interface ContactoServicio {

	public List<Contact> getContactList();
	
	public List<Contact> addContact(Contact contact);
	
	public List<Contact> deleteContact(int id);
	
}
