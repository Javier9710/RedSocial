package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Usuario;
import Modelo.UsuarioDao;

/**
 * Servlet implementation class BuscarControl
 */
@WebServlet("/BuscarControl")
public class BuscarControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario u = new Usuario();
	UsuarioDao uD= new UsuarioDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String consulta=request.getParameter("buscar");
		String accion= request.getParameter("accion");
		if(accion.equals("listar")) {
			
			List<Usuario>lista=uD.listar(consulta);
			  request.setAttribute("lista", lista);
			  request.getRequestDispatcher("listar.jsp").forward(request, response);
		}
	}

}
