package co.edu.uco.skilltrade.api.controller;

import org.slf4j.Logger;



import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.skilltrade.api.controller.response.Response;
import co.edu.uco.skilltrade.api.validator.curso.CrearCursoValidation;
import co.edu.uco.skilltrade.business.facade.concrete.RegistrarCursoFachadaImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.dto.CursoDTO;



@RestController
@RequestMapping("skilltrade/api/v1/curso")
public final class CursoController {
	
	Logger logger = LoggerFactory.getLogger(CursoDTO.class);
	private RegistrarCursoFachadaImpl facade;
	
	public CursoController() {
		facade = new RegistrarCursoFachadaImpl();
	}
	
	@GetMapping("/dummy")
	public CursoDTO dummy() {
		return CursoDTO.build();
	}
	
	@PostMapping
	public ResponseEntity<Response<CursoDTO>> create(
			@RequestBody CursoDTO dto) {

		var statusCode = HttpStatus.OK;
		var response = new Response<CursoDTO>();

		try {
			var result = CrearCursoValidation.validate(dto);

			if (result.getMessages().isEmpty()) {
				facade = new RegistrarCursoFachadaImpl();
				facade.ejecutar(dto);;
				response.getMessages().add("El curso se ha almacenado con éxito");
			} else {
				statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
				response.setMessages(result.getMessages());
			}

		} catch (final SkillTradeException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getLocalizedMessage());
			logger.error(exception.getLocalizedMessage().toString().concat("_").concat(exception.getMensajeUsuario()), exception);
		} catch (final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Ha habido un fallo al tratar de almacenar la informacion del curso");
			logger.error("Se ha presentado un problema inesperado, Por favor valida la consola de errores", exception);

		}

		return new ResponseEntity<>(response, statusCode);

	}

}
