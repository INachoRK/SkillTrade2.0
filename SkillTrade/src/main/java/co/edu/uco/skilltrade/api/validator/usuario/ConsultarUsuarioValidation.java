package co.edu.uco.skilltrade.api.validator.usuario;

import co.edu.uco.skilltrade.api.validator.Result;




import co.edu.uco.skilltrade.api.validator.Validation;
import co.edu.uco.skilltrade.api.validator.usuario.common.CorreoValidation;
import co.edu.uco.skilltrade.api.validator.usuario.common.PasswordValidation;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.UsuarioDTO;

public final class ConsultarUsuarioValidation implements Validation<UsuarioDTO>{
	
	private ConsultarUsuarioValidation() {
		super();
	}
	
	public static final Result validate(final UsuarioDTO data) {
		return new ConsultarUsuarioValidation().execute(data);
	}

	@Override
	public Result execute(UsuarioDTO data) {
		
		var result = Result.create();

		if (ObjectHelper.getObjectHelper().isNull(data)) {
			result.addMessage("La informacion que ha sido suminstrada está vacía");
		} else {

			result.addMessages(CorreoValidation.validate(data.getCorreo()).getMessages());
			result.addMessages(PasswordValidation.validate(data.getPassword()).getMessages());

		}
		return result;
	}
	
	

}
