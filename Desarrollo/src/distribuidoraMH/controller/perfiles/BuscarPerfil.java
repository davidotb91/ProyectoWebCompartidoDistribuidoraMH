package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Perfil;
import service.ServicioPerfil;

/**
 * Servlet implementation class BuscarPerfil
 */
@WebServlet("/BuscarPerfil")
public class BuscarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String txtUsuarioBusqueda = request.getParameter("txtUsuarioBusqueda");
		
		ServicioPerfil su= new ServicioPerfil();
		List<Perfil> u = su.consultarUsuarios(txtUsuarioBusqueda);
		request.setAttribute("usuarios", u);
		RequestDispatcher rd = request.getRequestDispatcher("AdminUsr.jsp");
		rd.forward(request, response);
	}

}
