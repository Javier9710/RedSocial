<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession sesion = request.getSession();
	Usuario u = (Usuario) sesion.getAttribute("usuario");
	sesion.invalidate();
	String site = new String("http://localhost:8080/RedSocial2.0/index.jsp");
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", site);
	%>

</body>
</html>