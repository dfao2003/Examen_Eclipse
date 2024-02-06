package ec.edu.ups.est.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.edu.ups.est.dao.proveedorDAO;
import ec.edu.ups.est.dao.recargaDAO;
import ec.edu.ups.est.modelo.Operador;
import ec.edu.ups.est.modelo.Recarga;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject 
	private recargaDAO daoRecarga;
	
	@Inject
	private proveedorDAO daoOperador;
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando");
		
		Date fecha = new Date();
		
		List<Recarga> recargaLista = new ArrayList<Recarga>();
		
		Operador operador = new Operador();
		operador.setNombre("Movistar");
		operador.setListarecarga(null);
		
		daoOperador.insert(operador);
		
		Recarga recarga = new Recarga();
		recarga.setNumero("0987654321");
		recarga.setMonto(5);
		recarga.setFecha(fecha);
		recarga.setOperador(operador);
		
		Recarga recarga2 = new Recarga();
		recarga2.setNumero("0489543627");
		recarga2.setMonto(6);
		recarga2.setFecha(fecha);
		recarga2.setOperador(operador);
		
		System.out.println(recarga.toString());
		
		recargaLista.add(recarga);
		recargaLista.add(recarga2);
		
		daoRecarga.insert(recarga);
		daoRecarga.insert(recarga2);
		
		operador.setListarecarga(recargaLista);
		
		daoOperador.update(operador);
		
		
		
		
	}
	
}
