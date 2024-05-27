
public class DatosException extends CalculadoraException {
	private static final long serialVersionUID = 1987316538836568973L;

	public DatosException(String mensaje) {
		super(mensaje, "Datos");
	}

	public DatosException(String mensaje, Throwable excepcionRaiz) {
		super(mensaje, excepcionRaiz, "Datos");
	}

}
