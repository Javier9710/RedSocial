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
 * Servlet implementation class PerfilControl
 */
@WebServlet("/PerfilControl")
public class PerfilControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UsuarioDao uD=new UsuarioDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		String email=u.getEmail();
		String Foto=uD.foto(email);
		System.out.print(Foto);
		
		request.setAttribute("Foto", Foto);
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		 
	}

}
