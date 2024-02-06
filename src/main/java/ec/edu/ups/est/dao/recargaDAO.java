package ec.edu.ups.est.dao;

import java.util.List;

import ec.edu.ups.est.modelo.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class recargaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Recarga recarga) {
		em.persist(recarga);
	}
	
	public void update(Recarga recarga) {
		em.merge(recarga);
	}
	
	public void remove(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		em.remove(recarga);
	}
	
	public Recarga read(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		return recarga;
	}
	
	
	public List<Recarga> getAll(){
		String jpql = "SELECT c FROM Recarga c";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
}
