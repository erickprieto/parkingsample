package mx.com.roth.parkingsite;

import java.util.Date;

import mx.com.roth.parkingsite.models.Auto;
import mx.com.roth.parkingsite.models.AutoNoEncontradoException;
import mx.com.roth.parkingsite.models.Estacionamiento;
import mx.com.roth.parkingsite.models.EstacionamientoLlenoException;
import mx.com.roth.parkingsite.models.EstacionamientoVacioException;
import mx.com.roth.parkingsite.models.LoteEstacionamiento;


/**
 * Run
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main(String[] args)
    {	        	
    	Estacionamiento estacionamiento = new Estacionamiento();
    	System.out.println( "== Bienvenido al estacionamiento ==" );
    	
        try {

			estacionamiento.ingresaAuto(new Auto("194VPH"), new Date(2016, 10, 25));
			estacionamiento.ingresaAuto(new Auto("164BKE"), new Date(2016, 10, 25));
			LoteEstacionamiento salida = estacionamiento.retiraAuto(new Date(2016,10,26));
			System.out.println(salida.toString() + " tardo: " + salida.estanciaCalculo() + " segundos");
			salida = estacionamiento.retiraAuto("164BKE", new Date(2016, 10, 27));
			System.out.println(salida.toString() + " tardo: " + salida.estanciaCalculo() + " segundos");
			salida = estacionamiento.retiraAuto("655PDD", new Date(2016, 10, 27));

		} catch (EstacionamientoLlenoException exLleno) {
			System.out.println( "== Lo Siento Estacionamiento Lleno ==" );
			exLleno.printStackTrace();
		} catch (EstacionamientoVacioException exVacio) {			
			System.out.println( "== Estacionamiento Vacio ==" );
			exVacio.printStackTrace();
		} catch (AutoNoEncontradoException exNoEncontrado) {
			System.out.println( "== Lo Siento Auto NO encontrado ==" );
			exNoEncontrado.printStackTrace();
		} finally {
			System.out.println("== Adios ==");
		} 
        
    }
}
