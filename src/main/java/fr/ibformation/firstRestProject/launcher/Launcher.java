package fr.ibformation.firstRestProject.launcher;

import fr.ibformation.firstRestProject.dao.DAOContactInDatabase;
import fr.ibformation.firstRestProject.dao.DAOGeneric;
import fr.ibformation.firstRestProject.dao.NotFindException;
import fr.ibformation.firstRestProject.metier.Contact;

public class Launcher {

	public static void main(String[] args) 
	{


		DAOGeneric<Contact> dao = new DAOContactInDatabase();


		Contact c = new Contact("Balan", "Michael", 32, "02");
		//dao.create(c);


		try {
			c = dao.readById(10);

			System.out.println(c);

			c.setAge(33);

			dao.update(c);

			System.out.println(dao.readById(23));

			System.out.println(dao.getAll());

			dao.deleteById(1);

		} catch (NotFindException e) {
			e.printStackTrace();
		}
		//		List<Contact> contacts = dao.getAll();
		//		System.out.println(contacts.size());
		//		
		//		
		//		System.out.println(dao.getAll());
	}

}
