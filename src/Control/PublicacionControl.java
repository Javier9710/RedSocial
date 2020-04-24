package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Modelo.Publicacion;
import Modelo.PublicacionDao;
import Modelo.Usuario;

@MultipartConfig
/**
 * Servlet implementation class PublicacionControl
 */
@WebServlet("/PublicacionControl")
public class PublicacionControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PublicacionDao pD = new PublicacionDao();
	Publicacion p = new Publicacion();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublicacionControl() {
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
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		Usuario u = (Usuario) sesion.getAttribute("usuario");

		List<Publicacion> lista1 = pD.listar1(u.getId());
		request.setAttribute("lista1", lista1);
		request.getRequestDispatcher("perfil.jsp").forward(request, response);

		String accion = request.getParameter("accion1");
		System.out.println(accion);
		if (accion.equals("publicar")) {

			Part foto1 = request.getPart("foto");
			String foto2 = pD.fileName(foto1);
			String foto = (foto2.replaceAll("\\\\", "\\\\\\\\"));
			String descripcion = request.getParameter("descripcion");
			p.setUsuario(u.getId());
			p.setFoto(foto);
			p.setDescripcion(descripcion);

		}
		if (pD.registrar(p)) {

			String site = new String("http://localhost:8080/RedSocial2.0/perfil.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

		} else {

			String site = new String("http://localhost:8080/RedSocial2.0/registro.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

		}
	}

}
