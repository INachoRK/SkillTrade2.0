
public class CalculadoraException extends RuntimeException {
	private static final long serialVersionUID = 1987316538836568973L;

	private String lugar;

	public CalculadoraException(String mensaje, String lugar) {
		super(mensaje);
		this.lugar = lugar;
	}

	public CalculadoraException(String mensaje, Throwable excepcionRaiz, String lugar) {
		super(mensaje, excepcionRaiz);
		this.lugar = lugar;
	}

	public String getLugar() {
		return lugar;
	}
}
