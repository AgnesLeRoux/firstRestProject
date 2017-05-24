
function get()
{
	$.getJSON("http://localhost:8080/firstRestProject/rest/contact1/contacts",
			function(data)
			{
					$("#contacts").html("");
					for(var i=0; i<data.length; i++)
					{
						$("#contacts").append("<p>"+data[i].nomContact+"  " 
								+data[i].prenomContact + " "
								+data[i].age+
								"</p>");
					}
			}
			);
}


function erase()
{
	$("#contacts").html("");
}


function post()
{
	console.log("post");
	console.log($("#nom").val());
	var data = {
			"id": 0,
			"numeroTelephone":$("#telephone").val(),
			"prenomContact": $("#prenom").val(),
			"age": $("#age").val(),
			"nomContact": $("#nom").val()
			};
	
//	$.post("http://localhost:8080/firstRestProject/rest/contact1",
//			JSON.stringify(data),
//			function(response){}
//		,'json'	);
	
	$.ajax({url: "http://localhost:8080/firstRestProject/rest/contact1",
			type: 'POST',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8;',
			dataType: 'json',
			async: false,
			success: function(msg){}
	}
			);
}
