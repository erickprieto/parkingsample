package mx.com.roth.parkingsite.models;

import java.io.Serializable;
import java.util.Date;

public class LoteEstacionamiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7498603943155617938L;

	private static final String LUGAR_VACIO = "VACIO";
	
	public static LoteEstacionamiento generarLugarVacio() {
		return new LoteEstacionamiento();
	}
	
	public static LoteEstacionamiento generarLugarMinusvalidoVacio() {
		return new LoteEstacionamiento(true);
	}
	
	private Auto autoAsignado;
	private boolean minusvalido = false;
	private Date fechaEntrada;
	private Date fechaSalida;
	
	private LoteEstacionamiento() {
		this.fechaEntrada = new Date(0);
		this.fechaSalida = new Date(0);
	}
	
	private LoteEstacionamiento(boolean minusvalido) {
		this();
		this.minusvalido = minusvalido;	
	}
	
	public LoteEstacionamiento(Auto autoAsignado, Date fechaHoraEntrada) {
		this();
		this.autoAsignado = autoAsignado;
		this.fechaEntrada = fechaHoraEntrada;
	}

	/**
	 * No tiene Auto Estacionado
	 * @return
	 */
	public boolean isEmpty() {
		return (autoAsignado == null);
	}
	
	public Auto getAutoAsignado() {
		return autoAsignado;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public long estanciaCalculo() {
		if(this.fechaSalida.getTime() == 0L) {
			return 0L; 
			} else {
				return (fechaSalida.getTime() - fechaEntrada.getTime())/ 1000L;
			}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((autoAsignado == null) ? 0 : autoAsignado.hashCode());
		result = prime * result
				+ ((fechaEntrada == null) ? 0 : fechaEntrada.hashCode());
		result = prime * result
				+ ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + (minusvalido ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoteEstacionamiento other = (LoteEstacionamiento) obj;
		if (autoAsignado == null) {
			if (other.autoAsignado != null)
				return false;
		} else if (!autoAsignado.equals(other.autoAsignado))
			return false;
		if (fechaEntrada == null) {
			if (other.fechaEntrada != null)
				return false;
		} else if (!fechaEntrada.equals(other.fechaEntrada))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (minusvalido != other.minusvalido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(isEmpty()) {
			return LUGAR_VACIO;
		} else { 
			return this.autoAsignado.toString();
		}
	}

}
