package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Producto;

public class ServicioProducto {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDDMH");
    EntityManager em = emf.createEntityManager();
	
    public String crearProducto(Producto u){
		String mensaje = "Perfil :D creado exitosamente";
		
        em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		return mensaje;
	}
    
    public String actualizarProducto (Producto u){
		String mensaje="USUARIo creado Exitosamente";
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		
		return mensaje;
	}
	
	public Producto consultarCliente (int id){
		Producto u = em.find(Producto.class, id);
		return u;
	}
	
	public List<Producto> consultarCliente (String ci){

		Query query = em.createQuery(
			      "SELECT u FROM Cliente AS u where u.ci like ?", Producto.class);
		query.setParameter(1,ci);
			  
		return query.getResultList();
	}
	
	public String eliminarCliente (Producto u){
		String mensaje="Usuario eliminado Exitosamente";
		return mensaje;
	}
}
