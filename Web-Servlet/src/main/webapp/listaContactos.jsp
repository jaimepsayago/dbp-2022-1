<%@page import="pucese.edu.ec.Contactos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--importar librerias  -->
  <%@ page import="java.util.ArrayList"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libreta de Direcciones</title>
</head>

<!--  generar una variable para agregar la clase contactos-->
<%
ArrayList<Contactos> contactos;
%>

<body>
<%
//creamos un obj contactos y que obtenga los parametros de la session contactos 
contactos = (ArrayList<Contactos>)session.getAttribute("contactos");
//procesar los datos de la pagina jsp para enviarlos a la clase Contactos
if (contactos == null){ //si esta vacio creamos un nuevo
	contactos = new ArrayList<Contactos>(); //inicializamos un nuevo obj contacto de tipo Contacto
	session.setAttribute("contactos",contactos);//la session creado envia el obj contactos
}

//obtener los parametros de la pagina web
String metodo = request.getMethod();

//obetener los atribtuso del formulario web
if ("POST".equals(metodo)){
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String telefono = request.getParameter("telefono");

//agregar los datos obtenidos a la clase contactos para que se guarden
Contactos contacto = new Contactos();
contacto.setNombre(nombre);
contacto.setApellido(apellido);
contacto.setTelefono(telefono);

//agregar los dastos en el arraylist contactos
contactos.add(contacto);

//System.out.println(contactos.toString());
}



%>
<form method="post">
<label>Nombre</label>
<input type="text" name = "nombre"/>

<label>Apellido</label>
<input type="text" name = "apellido"/>

<label>Telefono</label>
<input type="text" name = "telefono"/>

<button type="submit">Guardar</button>
</form>

<h1>contactos registrados</h1>

<table>
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Telefono</th>
		</tr>
	</thead>
	<tbody>
	<% for (Contactos c: contactos){
	%>
		<tr>
			<th><%=c.getNombre()%>	</th>
			<th><%=c.getApellido()%></th>
			<th><%=c.getTelefono()%></th>
		</tr>
	<% 
	}
	%>
	</tbody>
</table>












</body>
</html>