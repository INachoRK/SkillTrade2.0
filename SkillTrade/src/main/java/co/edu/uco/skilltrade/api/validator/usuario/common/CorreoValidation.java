package co.edu.uco.skilltrade.api.validator.usuario.common;

import co.edu.uco.skilltrade.api.validator.Result;

import co.edu.uco.skilltrade.api.validator.Validation;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class CorreoValidation implements Validation<String> {
	
	private CorreoValidation(){
		super();
	}
	
	public static final Result validate(final String data) {
		return new CorreoValidation().execute(data);
	}
	
	@Override
	public final Result execute(String data) {
		var result = Result.create();

		if (TextHelper.isNullOrEmpty(data)) {
			result.addMessage("No es posible continuar con el correo vacio");
		} if (TextHelper.emailStringIsValid(data)) {
			result.addMessage("El correo no cumple con el formato esperado");
		}

		return result;
	}

}
