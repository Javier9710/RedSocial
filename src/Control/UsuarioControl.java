package Control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.security.MD5Encoder;

import Modelo.Usuario;
import Modelo.UsuarioDao;

@MultipartConfig

/**
 * Servlet implementation class Parametros
 */
@WebServlet("/UsuarioControl")
public class UsuarioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Usuario u = new Usuario();
	UsuarioDao uD = new UsuarioDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		if (accion.equals("registrar")) {
			String usuario = request.getParameter("usuario");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String pass = request.getParameter("contra");
			Part archivo = request.getPart("foto");
			String context = request.getServletContext().getRealPath("img");
			String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString(); 
			//archivo.write(context + File.separator + foto);
			String fotoName =File.separator+ File.separator+foto;
			//motorista.setFoto(fotoName);
			System.out.print(fotoName);
			
			
			u.setUsuario(usuario);
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setEmail(email);
			u.setPass(pass);
			u.setFoto(fotoName);

		}
		if (uD.registrar(u)) {

			String site = new String("http://localhost:8080/RedSocial2.0/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

		} else {

			String site = new String("http://localhost:8080/RedSocial2.0/registro.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

		}

	}

}