
public class Negocio {

	public int sumar(int numeroUno, int numeroDos) {
		try {
			Datos datos = new Datos();
			datos.setNumeroUno(numeroUno);
			datos.setNumeroDos(numeroDos);

			int resultado = datos.getNumeroUno() + datos.getNumeroDos();

			if (resultado % 2 == 0) {
				throw new NegocioException("El resultado de la suma no puede ser un número par");
			}

			return resultado;
		} catch (CalculadoraException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new NegocioException("Algo raro pasó en el negocio", exception);
		}
	}

}