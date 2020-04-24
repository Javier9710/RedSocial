package Modelo;

import java.io.Serializable;
import java.sql.SQLException;

import Conexion.Conexion;

public class EtiquetaDao implements Serializable {

	Conexion con = null;

    public EtiquetaDao() {
        con = Conexion.getConexion();
    }

    public boolean registrar (Etiqueta etiqueta) {
    
        String sql = "INSERT INTO mensaje (id, usuario, publicacion, mensaje, fecha)"
                + "VALUES ('"+etiqueta.getId()+"','"+etiqueta.getUsuario()+"','"+etiqueta.getPublicacion()+"','"+etiqueta.getMensaje()+"','"+etiqueta.getFecha()+"')";
        try {
            con.insert(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
}