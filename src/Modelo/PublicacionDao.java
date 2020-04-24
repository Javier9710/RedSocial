package Modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import Conexion.Conexion;

public class PublicacionDao implements Serializable {

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

	public List<Publicacion> listar(int id) {

		List<Publicacion> lista = new ArrayList<>();

		String sql = "Select u.usuario, p.foto, p.fechapublicacion, p.descripcion"
				+    "from usuario u, publicacion p"
				+    "Where p.usuario=u.id"
				+    "And u.id='"+id+"'";
		try {
			ResultSet rs = con.query(sql);
			while (rs.next()) {
				Publicacion p = new Publicacion();
				p.setUsuario(id);
				p.setFoto(rs.getString("foto"));
				p.setFechaPublicacion(rs.getDate("fechapublicacion"));
				p.setDescripcion(rs.getString("descripcion"));
				lista.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return lista;

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