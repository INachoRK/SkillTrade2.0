package co.edu.uco.skilltrade.api.controller;

import java.util.List;



import org.slf4j.Logger;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "http://127.0.0.1:5501")
public final class CursoController {
	
	Logger logger = LoggerFactory.getLogger(CursoDTO.class);
	private RegistrarCursoFachadaImpl facade;
	private ConsultarCursoFachadaImpl fachada;
	
	@Autowired
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
        
		CursoResponse cursoResponse = CursoResponse.build();
        HttpStatus httpStatusResponse = HttpStatus.OK;

        try {
        	final var cursoDtoFilter = CursoDTO.build();
            
            fachada = new ConsultarCursoFachadaImpl();
            fachada.ejecutar(cursoDtoFilter);
            
            final List<CursoDTO> datosCurso = fachada.ejecutar(cursoDtoFilter);
            cursoResponse.setDatos(datosCurso);
            cursoResponse.getMensajes().add("Cursos consultadas exitosamente");
               
               
        } catch (final SkillTradeException exception) {
            logger.error("Error de negocio: ", exception);
            cursoResponse.getMensajes().add(exception.getMensajeUsuario());
            httpStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            logger.error("Error inesperado: ", exception);
            cursoResponse.getMensajes().add("Se ha presentado un problema inesperado");
            httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(cursoResponse, httpStatusResponse);
    }

}
