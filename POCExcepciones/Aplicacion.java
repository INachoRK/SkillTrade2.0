
public class Aplicacion {

	public static void main(String[] args) {
		try {
			Negocio negocio = new Negocio();
			int resultado = negocio.sumar(-1, 4);
			System.out.println(resultado);
		} catch (CalculadoraException exception) {
			System.out.println("Es algo de lo que tengo conocimiento");
			System.out.println(exception.getLugar());
			exception.printStackTrace();
		} catch (Exception excepcion) {
			System.out.println("Error inesperado");
			excepcion.printStackTrace();
		} finally {
			System.out.println("Sin importar que pasé siempre estaré ahí");
		}
	}

}
