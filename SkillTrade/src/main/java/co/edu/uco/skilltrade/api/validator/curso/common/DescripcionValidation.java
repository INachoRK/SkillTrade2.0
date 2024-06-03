package co.edu.uco.skilltrade.api.validator.curso.common;

import co.edu.uco.skilltrade.api.validator.Result;

import co.edu.uco.skilltrade.api.validator.Validation;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class DescripcionValidation implements Validation<String> {
	
	private DescripcionValidation() {
		super();
	}

	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);
	}

	@Override
	public final Result execute(String data) {
		var result = Result.create();

		if (TextHelper.isNullOrEmpty(data)) {
			result.addMessage("No es posible continuar con la descripcion vacio");
		} 

		return result;
	}

}
