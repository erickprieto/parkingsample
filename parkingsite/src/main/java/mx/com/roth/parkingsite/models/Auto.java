package mx.com.roth.parkingsite.models;

import java.io.Serializable;

public class Auto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1627140727620994479L;
	
	private String placas;
	private String color;
	private int año;
	private String modelo;
	private boolean minusvalido;
	
	public Auto() {		
		super();
		// TODO Auto-generated constructor stub
		this.placas = "";
		this.color = "";
		this.año = 1900;
		this.modelo = "";
		this.minusvalido = false;
	}
	
	public Auto(String placas) {
		this();
		this.placas = placas;
	}
	
	public String getPlacas() {
		return placas;
	}

	public String getColor() {
		return color;
	}

	public int getAño() {
		return año;
	}

	public String getModelo() {
		return modelo;
	}

	public boolean isMinusvalido() {
		return minusvalido;
	}

	public void setPlacas(String placas) {
		this.placas = placas;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMinusvalido(boolean minusvalido) {
		this.minusvalido = minusvalido;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + año;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (minusvalido ? 1231 : 1237);
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placas == null) ? 0 : placas.hashCode());
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
		Auto other = (Auto) obj;
		if (año != other.año)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (minusvalido != other.minusvalido)
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placas == null) {
			if (other.placas != null)
				return false;
		} else if (!placas.equals(other.placas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auto: " + this.placas;
	}
	
	
}
