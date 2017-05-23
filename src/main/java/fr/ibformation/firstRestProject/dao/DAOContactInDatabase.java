package fr.ibformation.firstRestProject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.ibformation.firstRestProject.metier.Contact;

public class DAOContactInDatabase implements DAOGeneric<Contact> {

	private ConnectionDatabase connectionDatabase;
	
	public DAOContactInDatabase() {
		connectionDatabase = ConnectionDatabase.getConnectionDatabase();
	}

	public void create(Contact c) {
		try {
			PreparedStatement pstmnt;
			String request = "INSERT INTO nouvellebdd.contact "
					+ "(nom_contact, carnet_id, age, prenom_contact,numero_telephone)"
					+ " VALUES (?, 2, ?, ?, ?);";
			pstmnt = connectionDatabase.getConnection().prepareStatement(request);
			pstmnt.setString(1,c.getNomContact());
			pstmnt.setInt(2,c.getAge());
			pstmnt.setString(3,c.getPrenomContact());
			pstmnt.setString(4,c.getNumeroTelephone());
			pstmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public Contact readById(int id) {
		Contact c = null;
		try 
		{
			String request = "SELECT * FROM nouvellebdd.contact WHERE contact.contact_id =(?);";
			PreparedStatement pstmnt = connectionDatabase.getConnection().prepareStatement(request);
			pstmnt.setInt(1, id);
			ResultSet rs = pstmnt.executeQuery();
			while(rs.next())
			{
				c = new Contact(rs.getInt("contact_id"),rs.getString("nom_contact"),rs.getString("prenom_contact"),
						rs.getInt("age"),rs.getString("numero_telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	public Contact readByName(String name) {
		Contact c = null;
		try 
		{
			String request = "SELECT * FROM nouvellebdd.contact WHERE contact.nom_contact =(?);";
			PreparedStatement pstmnt = connectionDatabase.getConnection().prepareStatement(request);
			pstmnt.setString(1, name);
			ResultSet rs = pstmnt.executeQuery();
			while(rs.next())
			{
				c = new Contact(rs.getString("nom_contact"),rs.getString("prenom_contact"),
						rs.getInt("age"),rs.getString("numero_telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void update(Contact c) {
		System.out.println(c);
		try {
			String request = "UPDATE nouvellebdd.contact SET "
					+ " nom_contact=?,"
					+ " age=?,"
					+ " prenom_contact=?,"
					+ " numero_telephone=?"
					+ " WHERE contact_id=?";
			PreparedStatement pstmnt = connectionDatabase.getConnection().prepareStatement(request);
			pstmnt.setString(1, c.getNomContact());
			pstmnt.setInt(2, c.getAge());
			pstmnt.setString(3, c.getPrenomContact());
			pstmnt.setString(4, c.getNumeroTelephone());
			pstmnt.setInt(5, c.getId());
			pstmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void deleteById(int id)
	{
		
		try {
			String request = "DELETE FROM nouvellebdd.contact WHERE contact_id=?";
			PreparedStatement pstmnt = connectionDatabase.getConnection().prepareStatement(request);
			pstmnt.setInt(1, id);
			pstmnt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteByName(Contact c) {
		// TODO Auto-generated method stub
		
	}

	public List<Contact> getAll() {
		List<Contact> contacts = null;

		try {
			Statement stmt = connectionDatabase.getConnection().createStatement();
			String request = "SELECT * FROM nouvellebdd.contact";
			ResultSet rs = stmt.executeQuery(request);
			
			contacts = new ArrayList<Contact>();
			
			while (rs.next()) 
			{
				Contact c = new Contact(rs.getInt("contact_id"), rs.getString("nom_contact"),rs.getString("prenom_contact"),
						rs.getInt("age"),rs.getString("numero_telephone")
						);

				contacts.add(c);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contacts;
	}





}
