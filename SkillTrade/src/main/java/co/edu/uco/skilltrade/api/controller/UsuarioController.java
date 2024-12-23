package co.edu.uco.skilltrade.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.skilltrade.api.controller.response.Response;
import co.edu.uco.skilltrade.api.controller.response.usuario.UsuarioResponse;
import co.edu.uco.skilltrade.business.facade.concrete.ConsultarUsuarioFachadaImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.dto.UsuarioDTO;

@RestController
@RequestMapping("skilltrade/api/v1/usuario")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public final class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private ConsultarUsuarioFachadaImpl fachada;

    @GetMapping("/dummy")
    public UsuarioDTO dummy() {
        return UsuarioDTO.build();
    }

    @GetMapping
    public ResponseEntity<Response<UsuarioDTO>> consultar(
    		@RequestBody UsuarioDTO dto) {
        
        UsuarioResponse usuarioResponse = UsuarioResponse.build();
        HttpStatus httpStatusResponse = HttpStatus.OK;

        try {
            final var usuarioDtoFilter = UsuarioDTO.build().setCorreo(dto.getCorreo()).setPassword(dto.getPassword());
            final boolean resultadoAcceso = fachada.ejecutarLogin(usuarioDtoFilter);
            
            if (!resultadoAcceso) {
                usuarioResponse.getMensajes().add("Usuario no encontrado o contraseña incorrecta");
                usuarioResponse.setAccesoAutorizado(false);
                httpStatusResponse = HttpStatus.UNAUTHORIZED;
            } else {
                usuarioResponse.getMensajes().add("Acceso autorizado");
                usuarioResponse.setAccesoAutorizado(true);
                
            }
        } catch (final SkillTradeException exception) {
            logger.error("Error de negocio: ", exception);
            usuarioResponse.getMensajes().add(exception.getMensajeUsuario());
            httpStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            logger.error("Error inesperado: ", exception);
            usuarioResponse.getMensajes().add("Se ha presentado un problema inesperado");
            httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(usuarioResponse, httpStatusResponse);
    }

}
