package co.edu.uco.skilltrade.api.validator.curso;

import co.edu.uco.skilltrade.api.validator.Result;


import co.edu.uco.skilltrade.api.validator.Validation;
import co.edu.uco.skilltrade.api.validator.sesion.common.DescripcionValidation;
import co.edu.uco.skilltrade.api.validator.sesion.common.TituloValidation;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.CursoDTO;

public final class CrearCursoValidation implements Validation<CursoDTO>{
	
	private CrearCursoValidation() {
		super();
	}
	
	public static final Result validate(final CursoDTO data) {
		return new CrearCursoValidation().execute(data);
	}

	@Override
	public Result execute(CursoDTO data) {
		
		var result = Result.create();

		if (ObjectHelper.getObjectHelper().isNUll(data)) {
			result.addMessage("La informacion que ha sido suminstrada está vacía");
		} else {

			result.addMessages(TituloValidation.validate(data.getTitulo()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());

		}
		return result;
	}
	
	

}
