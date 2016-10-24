package mx.com.roth.parkingsite.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estacionamiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5013952705446608079L;
	
	private static final int TOTAL_LUGARES_ESTACIONAMIENTO = 10;
	
	private List<LoteEstacionamiento> lugares;

	public Estacionamiento() {
		super();
		this.lugares = new ArrayList<LoteEstacionamiento>(TOTAL_LUGARES_ESTACIONAMIENTO);
		inicilizaLugares();
	}

	private void inicilizaLugares() {
		for(int i = 0; i < TOTAL_LUGARES_ESTACIONAMIENTO; i++) {
			this.lugares.add(i, LoteEstacionamiento.generarLugarVacio());	
		}	
	}
	
	private int lugaresDisponibles() {
		int total = 0;
		for (int i = 0; i < TOTAL_LUGARES_ESTACIONAMIENTO; i++) {
			if(this.lugares.get(i).isEmpty()){
				total++;
			}
		}
		return total;
	}
	
	private int encuentraPrimerLugarDisponible() throws EstacionamientoLlenoException {
		for (int i = 0; i < TOTAL_LUGARES_ESTACIONAMIENTO; i++) {
			if(this.lugares.get(i).isEmpty()) {
				return i;
			} 
		}
		throw new EstacionamientoLlenoException();
	}
	
	private int encuentraPrimerLugarOcupado() throws EstacionamientoVacioException {
		for (int i = 0; i < TOTAL_LUGARES_ESTACIONAMIENTO; i++) {
			if(!this.lugares.get(i).isEmpty()) {
				return i;
			} 
		}
		throw new EstacionamientoVacioException();
	}
	
	private int encuentraPlacas(String placas) throws AutoNoEncontradoException {
		for (int i = 0; i < TOTAL_LUGARES_ESTACIONAMIENTO; i++) {
			if(!this.lugares.get(i).isEmpty() && this.lugares.get(i).getAutoAsignado().getPlacas().equals(placas)) {
				return i;
			} 
		}
		throw new AutoNoEncontradoException(placas);
	}
	
	public int ingresaAuto(Auto auto, Date entradafecha) throws EstacionamientoLlenoException {

			if(lugaresDisponibles() > 0) {
				this.lugares.set(encuentraPrimerLugarDisponible(), new LoteEstacionamiento(auto, entradafecha));
				System.out.println("Recibido Corrrectamente. "+ auto.toString());
				return lugaresDisponibles();
			}		
			throw new EstacionamientoLlenoException();

	}


	public LoteEstacionamiento retiraAuto(Date salidafecha) throws EstacionamientoVacioException {
		int lugar = encuentraPrimerLugarOcupado();
		LoteEstacionamiento saliente = this.lugares.remove(lugar);
		saliente.setFechaSalida(salidafecha);
		System.out.println("Saliendo Corrrectamente. ");
		this.lugares.add(lugar, LoteEstacionamiento.generarLugarVacio());
			
		return saliente;

	}

	public LoteEstacionamiento retiraAuto(String placa, Date salidafecha) throws AutoNoEncontradoException {
		int lugar = encuentraPlacas(placa);
		LoteEstacionamiento saliente = this.lugares.remove(lugar);
		saliente.setFechaSalida(salidafecha);
		System.out.println("Saliendo Corrrectamente. ");
		this.lugares.add(lugar, LoteEstacionamiento.generarLugarVacio());
			
		return saliente;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lugares == null) ? 0 : lugares.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Estacionamiento other = (Estacionamiento) obj;
		if (lugares == null) {
			if (other.lugares != null)
				return false;
		} else if (!lugares.equals(other.lugares))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estacionamiento [lugares=" + lugares + "]";
	}
	
}
