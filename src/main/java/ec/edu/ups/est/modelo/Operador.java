package ec.edu.ups.est.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Operador {
	
	@Id
	@Column(name = "ID_OPERADOR")
	private int idOperador;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy = "recarga")
	private List<Recarga> Listarecarga;

	public int getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Recarga> getListarecarga() {
		return Listarecarga;
	}

	public void setListarecarga(List<Recarga> listarecarga) {
		Listarecarga = listarecarga;
	}

	@Override
	public String toString() {
		return "Operador [idOperador=" + idOperador + ", nombre=" + nombre + ", Listarecarga=" + Listarecarga + "]";
	}
	
	
	
	
	
	
}
