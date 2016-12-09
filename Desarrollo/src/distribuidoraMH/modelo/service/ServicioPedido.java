package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Pedido;


public class ServicioPedido {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDDMH");
    EntityManager em = emf.createEntityManager();
	
    public String crearPedido(Pedido u){
		String mensaje = "Perfil :D creado exitosamente";
		
        em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		return mensaje;
	}
    
    public String modificarPedido (Pedido u){
		String mensaje="USUARIo creado Exitosamente";
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		
		return mensaje;
	}
	
	public Pedido consultarPedido (int id){
		Pedido u = em.find(Pedido.class, id);
		return u;
	}
	
	public List<Pedido> consultarCliente (String ci){

		Query query = em.createQuery(
			      "SELECT u FROM Cliente AS u where u.ci like ?", Pedido.class);
		query.setParameter(1,ci);
			  
		return query.getResultList();
	}
	
	public String eliminarCliente (Pedido u){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}
}
