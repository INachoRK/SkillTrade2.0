package co.edu.uco.skilltrade.api.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.skilltrade.api.controller.response.Response;
import co.edu.uco.skilltrade.api.controller.response.curso.CursoResponse;
import co.edu.uco.skilltrade.api.validator.curso.CrearCursoValidation;
import co.edu.uco.skilltrade.business.facade.concrete.ConsultarCursoFachadaImpl;
import co.edu.uco.skilltrade.business.facade.concrete.RegistrarCursoFachadaImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.dto.CursoDTO;

@RestController
@RequestMapping("skilltrade/api/v1/curso")
@CrossOrigin(origins = {
    "http://127.0.0.1:5501", 
    "http://127.0.0.1:5500",
    "http://localhost:5501",
    "http://localhost:5500"
})
public final class CursoController {
	
	Logger logger = LoggerFactory.getLogger(CursoDTO.class);
	private RegistrarCursoFachadaImpl facade;
	private ConsultarCursoFachadaImpl fachada;
	
	public CursoController() {
		facade = new RegistrarCursoFachadaImpl();
		fachada = new ConsultarCursoFachadaImpl();
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
				facade.ejecutar(dto);
				response.getData().add(dto);
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
	
	
	@GetMapping
	public ResponseEntity<Response<CursoDTO>> consultar() {
	    Response<CursoDTO> response = new Response<>();
	    HttpStatus statusCode = HttpStatus.OK;

	    try {
	        logger.info("Iniciando consulta de cursos"); // Debug
	        final var cursoDtoFilter = CursoDTO.build();
	        
	        logger.info("Ejecutando consulta con filtro: {}", cursoDtoFilter); // Debug
	        final List<CursoDTO> datosCurso = fachada.ejecutar(cursoDtoFilter);
	        
	        if (datosCurso != null) {
	            response.setData(datosCurso);
	            response.getMessages().add("Cursos consultados exitosamente");
	            logger.info("Consulta exitosa. Cursos encontrados: {}", datosCurso.size());
	        } else {
	            response.getMessages().add("No se encontraron cursos");
	            logger.info("Consulta exitosa. No se encontraron cursos");
	        }
	        
	    } catch (final SkillTradeException exception) {
	        statusCode = HttpStatus.BAD_REQUEST;
	        response.getMessages().add(exception.getMensajeUsuario());
	        logger.error("Error de negocio en consulta de cursos: {}", exception.getMessage(), exception);
	    } catch (final Exception exception) {
	        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        response.getMessages().add("Se ha presentado un problema inesperado al consultar los cursos");
	        logger.error("Error inesperado en consulta de cursos: ", exception);
	    }

	    return new ResponseEntity<>(response, statusCode);
	}
}
