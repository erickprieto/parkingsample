package mx.com.roth.parkingsite.models;

public class AutoNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3077901008855229465L;
	
	public AutoNoEncontradoException() {
		super();
	}

	public AutoNoEncontradoException(String message) {
		super(message);
	}
}
