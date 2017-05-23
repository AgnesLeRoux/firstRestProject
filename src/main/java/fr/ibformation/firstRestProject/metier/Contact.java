package fr.ibformation.firstRestProject.metier;

public class Contact {
	
	private int id;
	private String nomContact;
	private String prenomContact;
	private int age;
	private String numeroTelephone;
	
	
	public Contact() {
	}


	public Contact(String nomContact, String prenomContact, int age, String numeroTelephone) {
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.age = age;
		this.numeroTelephone = numeroTelephone;
	}

	public Contact(int id, String nomContact, String prenomContact, int age, String numeroTelephone) {
		this.id = id;
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.age = age;
		this.numeroTelephone = numeroTelephone;
	}
	

	public String getNomContact() {
		return nomContact;
	}


	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}


	public String getPrenomContact() {
		return prenomContact;
	}


	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getNumeroTelephone() {
		return numeroTelephone;
	}


	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}


	@Override
	public String toString() {
		return "Contact [id="+ id+ " nomContact=" + nomContact + ", prenomContact=" + prenomContact + ", age=" + age
				+ ", numeroTelephone=" + numeroTelephone + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
