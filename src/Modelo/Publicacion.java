package Modelo;

import java.io.Serializable;
import java.util.Date;

public class Publicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4315670736524273299L;
	private int id;
	private String descripcion;
	private int usuario;
	private Date fechaPublicacion;
	private String foto;

	public Publicacion() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}