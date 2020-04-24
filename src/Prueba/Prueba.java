package Prueba;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.portable.InputStream;

import com.mysql.cj.jdbc.Blob;

import Conexion.Conexion;
import Modelo.Mensaje;
import Modelo.MensajeDao;
import Modelo.Usuario;
import Modelo.UsuarioDao;


public class Prueba {
	
	 Conexion con = null;

	    
	
	public static void main(String[] args) {
		
	

		
		Conexion con= Conexion.getConexion();
		 int var =17;
		 
		 UsuarioDao uD=new UsuarioDao();
		
		 System.out.print(uD.foto("javi@gmail.com"));
	    

	  
	    	 
	    	   
	     
	     
		 
	}


	}
	
	



	
	

