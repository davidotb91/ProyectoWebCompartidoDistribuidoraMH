package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Perfil;


public class ServicioPerfil {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDDMH");
    EntityManager em = emf.createEntityManager();
	
    public String crearPerfil(Perfil u){
		String mensaje = "Perfil :D creado exitosamente";
		
        em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		return mensaje;
	}
    
    public String actualizarUsuario (Perfil u){
		String mensaje="USUARIo creado Exitosamente";
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		
		return mensaje;
	}
	
	public Perfil consultarUsuario (int id){
		Perfil u = em.find(Perfil.class, id);
		return u;
	}
	
	public List<Perfil> consultarUsuarios (String nombre){
		EntityManagerFactory emf = 
	       Persistence.createEntityManagerFactory(
	    		   "PruebaUsuario");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(
			      "SELECT u FROM Usuario AS u where u.nombreCompleto like ?", Perfil.class);
		query.setParameter(1,nombre);
			  
		return query.getResultList();
	}
	
	public String eliminarUsuario (Perfil u){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}

}
