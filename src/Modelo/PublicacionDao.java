package Modelo;

import java.io.Serializable;
import java.sql.SQLException;

import Conexion.Conexion;

public class PublicacionDao implements Serializable {

	Conexion con = null;

    public PublicacionDao() {
        con = Conexion.getConexion();
    }

    public boolean registrar (Publicacion publicacion) {
    
        String sql = "INSERT INTO mensaje (id, descripcion, usuario, fechaPublicacion, acceso)"
                + "VALUES ('"+publicacion.getId()+"','"+publicacion.getDescripcion()+"','"+publicacion.getUsuario()+"','"+publicacion.getFechaPublicacion()+"','"+publicacion.getAcceso()+"')";
        try {
            con.insert(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
}