
console.log("hello");


function Contact(id,nomContact,prenomContact,age,numeroTelephone)
{
	this.id = id;
	this.nomContact = nomContact;
	this.prenomContact = prenomContact;
	this.age = age;
	this.numeroTelephone = numeroTelephone;

}

var myDiv = document.getElementById("contacts");

function get()
{
	myDiv.innerHTML ="";
	var xmlhttp = new XMLHttpRequest();
	var url = 'http://localhost:8080/firstRestProject/rest/contact1/contacts';

	xmlhttp.onreadystatechange = function() //on affecte un callback 
	{
		if(this.readyState == 4 && this.status == 200)
		{
			var myArr = JSON.parse(this.responseText);
			//console.log(myArr);
			remplirLaZoneDeTexte(myArr);
		}
	};

	xmlhttp.open('GET',url);
	xmlhttp.send();
}

function remplirLaZoneDeTexte(myArr)
{	
	myDiv.innerHTML += "<ul>";
	for(var i=0;i<myArr.length; i++)
	{
		myDiv.innerHTML += "<li>"+myArr[i].nomContact +"  "+myArr[i].prenomContact + "</li>";
	}
	myDiv.innerHTML +="</lu>";
}
console.log("hdeayu");

function post()
{
	

	var nom = document.getElementById("nom").value;
	var prenom = document.getElementById("prenom").value;
	var age = parseInt(document.getElementById("age").value);
	var telephone = document.getElementById("telephone").value;

	var contact = new Contact(0,nom,prenom,age,telephone);

	var xmlhttp = new XMLHttpRequest();
	var url = 'http://localhost:8080/firstRestProject/rest/contact1';
	xmlhttp.onreadystatechange = function() 
	{
		if(this.readyState == 4 && this.status == 200)
		{
			
			console.log(this.responseText);

		}
	};

	xmlhttp.open('POST',url, true);
	xmlhttp.setRequestHeader("Content-Type","application/json");
	xmlhttp.send(JSON.stringify(contact));
}






