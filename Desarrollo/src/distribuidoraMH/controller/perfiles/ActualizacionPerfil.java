package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Perfil;
import service.ServicioPerfil;

/**
 * Servlet implementation class ActualizacionPerfil
 */
@WebServlet("/ActualizacionPerfil")
public class ActualizacionPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizacionPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtUsuario= request.getParameter("txtUsuario");
		String txtRol= request.getParameter("txtPerfil");
		String txtClave= request.getParameter("txtClave");
		String txtConfirmacionClave= request.getParameter("txtConfirmacionClave");
		
		Perfil p = new Perfil ();
		 
		p.setUsuario(txtUsuario);
		p.setRol(txtRol);
		p.setClave(txtClave);
		p.setEstado("A");
		
		if (txtClave.equals(txtConfirmacionClave)){
			// Invocacion Modelo
			ServicioPerfil su = new ServicioPerfil();
			String mensaje = su.actualizarUsuario(p);
			request.setAttribute("msgExito", mensaje);			
			request.getRequestDispatcher("AdminUsr.jsp").forward(request, response); 
		} else {
			request.setAttribute("msgError", "Clave difiere de confirmación");
			//se cargan los datos ya ingresados para que el usuario no tenga que
			//digitar nuevamente todos los datos
			request.setAttribute("usuario", p);
			request.getRequestDispatcher("editarUsuario.jsp").forward(request, response); 
		}
		
		
		
	}

}
