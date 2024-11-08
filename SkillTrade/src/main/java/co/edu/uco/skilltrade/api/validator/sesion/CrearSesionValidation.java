package co.edu.uco.skilltrade.api.validator.sesion;

import co.edu.uco.skilltrade.api.validator.Result;

import co.edu.uco.skilltrade.api.validator.Validation;
import co.edu.uco.skilltrade.api.validator.sesion.common.DescripcionValidation;
import co.edu.uco.skilltrade.api.validator.sesion.common.TituloValidation;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.SesionDTO;

public final class CrearSesionValidation implements Validation<SesionDTO>{
	
	private CrearSesionValidation() {
		super();
	}
	
	public static final Result validate(final SesionDTO data) {
		return new CrearSesionValidation().execute(data);
	}

	@Override
	public Result execute(SesionDTO data) {
		
		var result = Result.create();

		if (ObjectHelper.getObjectHelper().isNull(data)) {
			result.addMessage("La informacion que ha sido suminstrada está vacía");
		} else {

			result.addMessages(TituloValidation.validate(data.getTitulo()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());

		}
		return result;
	}
	
	

}
