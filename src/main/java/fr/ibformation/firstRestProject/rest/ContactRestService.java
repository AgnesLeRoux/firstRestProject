package fr.ibformation.firstRestProject.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ibformation.firstRestProject.dao.DAOContactInDatabase;
import fr.ibformation.firstRestProject.dao.NotFindException;
import fr.ibformation.firstRestProject.metier.Contact;

@Path("/contact")
public class ContactRestService 
{
	private DAOContactInDatabase daoContact = new DAOContactInDatabase();
	
	
	@GET
	@Path("/contacts")
	public String getContact()
	{
		return daoContact.getAll().toString();	
	}
	
	@GET
	@Path("/readName/{name}")
	public String getContactByName(@PathParam("name") String name)
	{
		return daoContact.readByName(name).toString();
	}

	@GET
	@Path("/readId/{id}")
	public String getContactById(@PathParam("id") int id)
	{
		Contact c;
		try {
			c = daoContact.readById(id);
		} catch (NotFindException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return c.toString();
		
	}
	
	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	public String createContact(@FormParam("nom")String nom,
			@FormParam("prenom")String prenom,
			@FormParam("age") int age,
			@FormParam("numeroTelephone") String numeroTelephone)
	{
		Contact c = new Contact( nom,  prenom,  age,  numeroTelephone);
		daoContact.create(c);
		System.out.println(c.toString());
		return "contact inserted "+ c.toString();
	}
	
	@PUT
	@Path("/update/{id}/{nom}/{prenom}")
	public String updateContact(@PathParam("id") int id,
			@PathParam("nom") String nom,
			@PathParam("prenom") String prenom)
	{
		
		Contact c = null;
		try {
			c = daoContact.readById(id);
		} catch (NotFindException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		c.setNomContact(nom);
		c.setPrenomContact(prenom);
		daoContact.update(c);
		
		return "ok";
	}
	
	@DELETE
	@Path("/delete/{id}")
	public String deleteContactById(@PathParam("id") int id)
	{
		daoContact.deleteById(id);
		return "contact deleted";
	}

}
