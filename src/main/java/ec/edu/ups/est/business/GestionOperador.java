package ec.edu.ups.est.business;

import ec.edu.ups.est.dao.proveedorDAO;
import ec.edu.ups.est.modelo.Operador;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionOperador {
	
	@Inject
	private proveedorDAO DAOprov;
	
	public Operador getOperadorPorId(int codigo) throws Exception{
		System.out.println("codigoOperador=" + codigo);
		return DAOprov.getOperadorPorId(codigo);
	}
	

}
