package fr.ibformation.firstRestProject.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ibformation.firstRestProject.dao.DAOContactInDatabase;
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
	@Path("/read/{name}/{prenom}")
	public String getContactByName(@PathParam("name") String name, @PathParam("prenom")String prenom)
	{
		return "ok pour read by name" + name+prenom;
		//return daoContact.readByName(name).toString();
		
	}
	
	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	public String createContact(@FormParam("nom")String nom,
			@FormParam("prenom")String prenom,
			@FormParam("age") int age,
			@FormParam("numeroTelephone") String numeroTelephone)
	{
		System.out.println("coucou");
		Contact c = new Contact( nom,  prenom,  age,  numeroTelephone);
		daoContact.create(c);
		System.out.println(c.toString());
		return "contact inserted";
	}
	
	
	

}
