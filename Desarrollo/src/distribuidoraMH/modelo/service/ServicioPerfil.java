package distribuidoraMH.modelo.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import distribuidoraMH.modelo.entity.Perfil;

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
}
