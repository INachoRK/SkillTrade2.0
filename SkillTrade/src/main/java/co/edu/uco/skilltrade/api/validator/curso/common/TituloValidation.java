package co.edu.uco.skilltrade.api.validator.curso.common;

import co.edu.uco.skilltrade.api.validator.Result;

import co.edu.uco.skilltrade.api.validator.Validation;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class TituloValidation implements Validation<String> {
	
	private TituloValidation(){
		super();
	}
	
	public static final Result validate(final String data) {
		return new TituloValidation().execute(data);
	}
	
	@Override
	public final Result execute(String data) {
		var result = Result.create();

		if (TextHelper.isNullOrEmpty(data)) {
			result.addMessage("No es posible continuar con el titulo vacio");
		} 

		return result;
	}

}
