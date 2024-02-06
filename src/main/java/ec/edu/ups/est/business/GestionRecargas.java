package ec.edu.ups.est.business;

import java.util.List;

import ec.edu.ups.est.dao.recargaDAO;
import ec.edu.ups.est.modelo.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {
	
	@Inject
	private recargaDAO daoRecarga;
	
	public void guardarRecarga(Recarga recarga) throws Exception{
		String numero = recarga.getNumero();
		if(numero.length() == 10) {
			daoRecarga.insert(recarga);
		}else {
			throw new Exception("El tamaño del celular no es correcto");
		}
	}
	
	public List<Recarga> getClientes(){
		return daoRecarga.getAll();
	}
	
	
}
