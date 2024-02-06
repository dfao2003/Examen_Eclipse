package ec.edu.ups.est.dao;

import java.util.List;

import ec.edu.ups.est.modelo.Operador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class proveedorDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Operador operador) {
		em.persist(operador);
	}
	
	public void update(Operador operador) {
		em.merge(operador);
	}
	
	public void remove(int codigo) {
		Operador operador = em.find(Operador.class, codigo);
		em.remove(operador);
	}
	
	public Operador read(int codigo) {
		Operador operador = em.find(Operador.class, codigo);
		return operador;
	}
	
	public Operador getOperadorPorId(int codigo){
		System.out.println("OperadorDao:" + codigo);
		String jpql = "SELECT c FROM Operador c WHERE c.idOperador = :codigo";
		Query q = em.createQuery(jpql, Operador.class);
		q.setParameter("cedula", codigo);
		List<Operador> operadoras = q.getResultList();
		if(operadoras.size()>0)
			return operadoras.get(0);
		return null;
	}
}
