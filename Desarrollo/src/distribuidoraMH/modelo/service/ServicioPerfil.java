package distribuidoraMH.modelo.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import distribuidoraMH.modelo.entity.Perfil;

public class ServicioPerfil {
	static EntityManager em =
			Persistence.createEntityManagerFactory("Kathy").createEntityManager();
	
	public String crearPerfil(Perfil p){
		String mensaje= "Registro Exitoso :D";
		try{
		em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		return mensaje;
	}
}
