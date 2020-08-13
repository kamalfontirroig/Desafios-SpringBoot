package cl.desafiolatam.contactmanager;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import cl.desafiolatam.contactmanager.model.Contact;
import cl.desafiolatam.contactmanager.servicios.ContactoServicio;
import cl.desafiolatam.contactmanager.servicios.impl.ContactoServicioImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("cl.desafiolatam.contactmanager.servicios")
public class ContactmanagerApplicationTests {

	@Test
	public void addContactTest() {

		ContactoServicio contactoServicio = new ContactoServicioImpl();

		contactoServicio.addContact(new Contact(0, "Kamal", "Fontirroig", "Martinez", "Micasa", 1241556));

		ArrayList<Contact> listaContacts = (ArrayList<Contact>) contactoServicio.getContactList();

		assertEquals(1, listaContacts.get(0).getIdContact());
	}

	@Test
	public void deleteContactTest() {

		ContactoServicio contactoServicio = new ContactoServicioImpl();

		contactoServicio.addContact(new Contact(0, "Kamal", "Fontirroig", "Martinez", "Micasa", 1241556));
		contactoServicio.addContact(new Contact(0, "Kamal", "Fontirroig", "Martinez", "Micasa", 1241556));
		contactoServicio.addContact(new Contact(0, "Kamal", "Fontirroig", "Martinez", "Micasa", 1241556));
		contactoServicio.addContact(new Contact(0, "Kamal", "Fontirroig", "Martinez", "Micasa", 1241556));
		
		contactoServicio.deleteContact(1);
		
		ArrayList<Contact> listaContacts = (ArrayList<Contact>) contactoServicio.getContactList();

		assertEquals(false, listaContacts.stream().anyMatch(contacto -> contacto.getIdContact() == 1));
	}

}
