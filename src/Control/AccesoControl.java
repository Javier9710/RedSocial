package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.Usuario;
import Modelo.UsuarioDao;

/**
 * Servlet implementation class AccesoControl
 */
@WebServlet("/AccesoControl")
public class AccesoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Usuario u = new Usuario();
	UsuarioDao uD = new UsuarioDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccesoControl() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String accion = request.getParameter("accion");
		if (accion.equals("ingresar")) {

			String correo = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			u.setEmail(correo);
			u.setPass(pass);
			Usuario r = uD.validar(u);
			
			System.out.print("esta es la foto :" +r);


			if (r!=null) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", r);
				String site = new String("http://localhost:8080/RedSocial2.0/inicio.jsp");
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site);

			} else {
				String site = new String("http://localhost:8080/RedSocial2.0/login.jsp");
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site);
			}

		}
	}

}
