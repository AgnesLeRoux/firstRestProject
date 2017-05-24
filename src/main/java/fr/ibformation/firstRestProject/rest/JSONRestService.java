package fr.ibformation.firstRestProject.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.ibformation.firstRestProject.dao.DAOContactInDatabase;
import fr.ibformation.firstRestProject.metier.Contact;

@Path("/contact1")
public class JSONRestService 
{
	
	private DAOContactInDatabase daoContact = new DAOContactInDatabase();

	@Path("test")
	@GET
	public String test()
	{
		return "Bravo";
	}

	@Path("jaxjson")
	@Consumes("application/json")
	@POST
	public String updateContentBooksWithJAXBXML(Contact current)
	{
		//System.out.println("Name: " + current.getNomContact() + ", prenom" + current.getPrenomContact());
		return "Name: " + current.getNomContact() + ", prenom" + current.getPrenomContact()+
				" "+current.getAge()
				+" "+current.getNumeroTelephone();
	}


	@Path("jaxjson")
	@GET
	@Produces(MediaType.APPLICATION_JSON) //equivalent to @Produces("application/json")
	public Contact getContact() 
	{
		System.out.println("start");
		Contact current = new Contact("sfdq","sfdq",23,"02");
		System.out.println(current);
		return current;
	}

	@Path("contacts")
	@GET
	@Produces(MediaType.APPLICATION_JSON) //equivalent to @Produces("application/json")
	public List<Contact> getAllContact() 
	{
		return daoContact.getAll();	
	}
	
	@POST
	@Consumes("application/json")
	public String createContact(Contact contact)
	{
		System.out.println("insertion contact hey");
		daoContact.create(contact);
		return "contact is inserted";
	}
	
	
}
