package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Cliente;

public class ServicioCliente {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDDMH");
    EntityManager em = emf.createEntityManager();
	
    public String crearCliente(Cliente u){
		String mensaje = "Perfil :D creado exitosamente";
		
        em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		return mensaje;
	}
    
    public String actualizarCliente (Cliente u){
		String mensaje="USUARIo creado Exitosamente";
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		
		return mensaje;
	}
	
	public Cliente consultarCliente (int id){
		Cliente u = em.find(Cliente.class, id);
		return u;
	}
	
	public List<Cliente> consultarCliente (String ci){

		Query query = em.createQuery(
			      "SELECT u FROM Cliente AS u where u.ci like ?", Cliente.class);
		query.setParameter(1,ci);
			  
		return query.getResultList();
	}
	
	public String eliminarCliente (Cliente u){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}
}
