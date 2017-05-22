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

	public Contact readByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}




	public void update(Contact c) {
		// TODO Auto-generated method stub
		
	}


	public void deleteById(int id)
	{
		
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
				Contact c = new Contact(rs.getString("nom_contact"),rs.getString("prenom_contact"),
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
