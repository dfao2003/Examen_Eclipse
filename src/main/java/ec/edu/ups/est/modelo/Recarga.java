package ec.edu.ups.est.modelo;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Recarga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRecarga;
	
	@Column(name = "NUMERO_TELEFONO", nullable = false)
	private String numero;
	
	@Column(name = "MONTO", nullable = false)
	private float monto;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	 @ManyToOne(cascade = CascadeType.PERSIST)
	 private Operador operador;

	public int getIdRecarga() {
		return idRecarga;
	}
	

	public void setIdRecarga(int idRecarga) {
		this.idRecarga = idRecarga;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}


	public Operador getOperador() {
		return operador;
	}


	public void setOperador(Operador operador) {
		this.operador = operador;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Recarga [idRecarga=" + idRecarga + ", numero=" + numero + ", monto=" + monto + ", fecha=" + fecha
				+ ", operador=" + operador + "]";
	}

	
	

	
	
	
}
