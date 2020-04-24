package Modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import Conexion.Conexion;

public class UsuarioDao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Conexion con = null;

	public UsuarioDao() {
		con = Conexion.getConexion();
	}

	public boolean registrar(Usuario usuario) {

		String sql = "INSERT INTO usuario (id, usuario, email, nombre, apellido, pass, fecharegistro, fechanacimiento, pais, foto)"
				+ "VALUES ('" + usuario.getId() + "','" + usuario.getUsuario() + "','" + usuario.getEmail() + "','"
				+ usuario.getNombre() + "','" + usuario.getApellido() + "'," + "'" + usuario.getPass() + "','"
				+ usuario.getFecharegistro() + "','" + usuario.getFechanacimiento() + "','" + usuario.getPais() + "','"
				+ usuario.getFoto() + "')";
		try {
			con.insert(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Usuario validar(Usuario usuario) {
		String sql = "Select * from usuario Where email='" + usuario.getEmail() + "' and pass = '" + usuario.getPass()
				+ "'";
		try {
			ResultSet rs = con.query(sql);
			if (rs.next()) {
				Usuario u = new Usuario();
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String nombre = rs.getString("nombre");
				String foto = rs.getString("foto");
				String usuario1 = rs.getString("usuario");
				u.setId(id);
				u.setEmail(email);
				u.setNombre(nombre);
				u.setFoto(foto);
				u.setUsuario(usuario1);

				return u;

			} else {

				return null;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Usuario> listar() {

		List<Usuario> lista = new ArrayList<>();

		String sql = "Select id,usuario,foto from usuario";
		try {
			ResultSet rs = con.query(sql);
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt(1));
				u.setUsuario(rs.getString(2));
				u.setFoto(rs.getString(3));
				lista.add(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return lista;

	}

	public String foto(String email) {
		String foto = "";

		String sql = "Select foto from usuario where email='" + email + "'";
		try {
			ResultSet rs = con.query(sql);
			while (rs.next()) {
				foto = rs.getString(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return foto;

	}

}
