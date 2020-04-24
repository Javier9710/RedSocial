package Modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import Conexion.Conexion;

public class PublicacionDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8228612826148776420L;
	Conexion con = null;

	public PublicacionDao() {
		con = Conexion.getConexion();
	}

	public boolean registrar(Publicacion publicacion) {

		String sql = "INSERT INTO publicacion (id, descripcion, usuario, foto)" + "VALUES ('" + publicacion.getId() + "','"
				+ publicacion.getDescripcion() + "','" + publicacion.getUsuario() + "','" + publicacion.getFoto()
				+ "')";
		try {
			con.insert(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Publicacion> listar1(int id) {
		
		System.out.println("1---"+id);
		List<Publicacion> lista1 = new ArrayList<>();

		String sql = "Select u.usuario, p.foto, p.fechapublicacion, p.descripcion"
				+    "from usuario u, publicacion p"
				+    "Where p.usuario=u.id"
				+    "And u.id='"+id+"'";
		System.out.println("estra por--2");
		try {
			ResultSet rs = con.query(sql);
			System.out.println("estra por--");
			while (rs.next()) {
				System.out.println("estra por--1");
				Publicacion p = new Publicacion();
				p.setUsuario(id);
				p.setFoto(rs.getString(2));
				p.setFechaPublicacion(rs.getDate(3));
				p.setDescripcion(rs.getString(4));
				System.out.println("2---"+rs.getString("foto"));
				System.out.println("3---"+rs.getDate("fechapublicacion"));
				System.out.println("4---"+rs.getString("descripcion"));
				lista1.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return lista1;

	}
	
	
	
	public String fileName(final Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}