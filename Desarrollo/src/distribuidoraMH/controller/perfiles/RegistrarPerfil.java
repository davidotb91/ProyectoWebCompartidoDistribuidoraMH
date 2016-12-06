package distribuidoraMH.controller.perfiles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import distribuidoraMH.modelo.entity.Perfil;
import distribuidoraMH.modelo.service.ServicioPerfil;

@WebServlet("/RegistrarPerfil")
public class RegistrarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegistrarPerfil() {
        super();
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
		//p.setIdPerfil(4);
		
		if(txtClave.equals(txtConfirmacionClave)){
			//Invocación  Modelo
			ServicioPerfil su = new ServicioPerfil();
			String resultado = su.crearPerfil(p);			
			request.setAttribute("msgExito",resultado);
			request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
		}else{
			request.setAttribute("msgError","Clave difere de confirmación");
			request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
		}
		
		
		
		
	}

}
