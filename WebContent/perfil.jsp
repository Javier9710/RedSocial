<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.ResultSet"%>
<%@page import="Conexion.Conexion" %>
<%
	HttpSession sesion = request.getSession();
Usuario u = (Usuario) sesion.getAttribute("usuario");
int id= u.getId();
String foto = u.getFoto();
String nombre = u.getNombre();
String usuario = u.getUsuario();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="css.css">
</head>
<body id="body1">
	<nav class="navbar navbar-expand-lg navbar-light bg-dark" id="nav">
		<div class="container">
			<div class="navbar-header">

				<ul class="nav navbar-nav">
					<li><a id="AG" href="inicio.jsp">AngieGram</a></li>
				</ul>

			</div>
			<form class="form-inline my-4 my-lg-0" action="BuscarControl"
				method="post">
				<input class="form-control mr-sm-4" type="search"
					placeholder="Buscar" aria-label="Search">
				<button class="btn btn-outline-light my-3 my-sm-0" name="accion"
					value="listar" type="submit">Buscar</button>
			</form>


			<li class="nav-item dropdown"><a class="nav dropdown-toggle"
				href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"><img src="<%=foto%>"
					height="60" width="60" style="border-radius: 10pc;"></a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="perfil.jsp">Perfil</a> <a
						class="dropdown-item" href="seguidores.jsp">Seguidores</a> <a
						class="dropdown-item" href="seguidos.jsp">Seguidos</a>
					<hr>
					<a class="dropdown-item" href="">Cerrar Sesión</a>
				</div></li>

		</div>

	</nav>


	<div class="container" id="lol">
		<div class="row align-items-start">
			<div class="col" align="center">
				<a href="perfil.jsp"><img src="<%=foto%>" id="perfil"
					height="150" width="150"
					style="border-radius: 10pc; width: 60%; height: 60%;"></a>
			</div>
			<div class="col" align="left">
				<h2><%=nombre%></h2>
				<h5><%=usuario%></h5>
				<div class="row">
					<div class="col-sm">Publicaciones:</div>
					<div class="col-sm">
						<a class="ab" href="seguidores.jsp">Seguidores: </a>
					</div>
					<div class="col-sm">
						<a class="ab" href="seguidos.jsp"> Seguidos: </a>
					</div>
				</div>

				<form class="form-inline my-4 my-lg-0" action="PublicacionControl"
					method="post" enctype="multipart/form-data">

					<br> <input type="file" class="form-control-file" name="foto"
						id="exampleFormControlFile1"><br> <br>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						name="descripcion" rows="2"></textarea>
					<br> <br>
					<button class="btn btn-outline-light my-3 my-sm-0" name="accion1"
						value="publicar" type="submit">Subir Foto</button>
				</form>
			</div>
		</div>
	</div>
	<br>
	
	<%
	
	Conexion con = Conexion.getConexion();
	
	String sql = "Select u.usuario, p.foto, p.fechapublicacion, p.descripcion "
			+    "from usuario u, publicacion p "
			+    "Where p.usuario=u.id "
			+    "And u.id="+id;
	
		ResultSet rs = con.query(sql);
	
	%>
	
	
	
	<div class="container" id="lol2">
		<table class="table">
			<thead>
				<tr>
					<th style="text-align: center" scope="col">Usuario</th>
					<th style="text-align: center" scope="col">Foto</th>
					<th style="text-align: center" scope="col">Descripcion</th>

				</tr>
			</thead>
			<tbody>
			<% while(rs.next()){
				
				%>

					<tr>
						<td style="text-align: center"><%=rs.getString(1)%></td>
						<td style="text-align: center"><img src="<%=rs.getString(2)%>"
							with="120px" height="120px"></td>
						<td style="text-align: center"><%=rs.getString(4)%></td>

						<td></td>


					</tr>
					<%} %>

				

			</tbody>

		</table>

	</div>
	<br>
	<footer class="bg-dark rounded-top text-center">
		<div class="container py-1">
			<p class="text-white my-2">Derechos Reservados 2020</p>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>