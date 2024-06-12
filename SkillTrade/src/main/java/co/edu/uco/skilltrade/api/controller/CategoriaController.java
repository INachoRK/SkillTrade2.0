package co.edu.uco.skilltrade.api.controller;

import java.util.List;




import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.skilltrade.api.controller.response.Response;
import co.edu.uco.skilltrade.api.controller.response.categoria.CategoriaResponse;
import co.edu.uco.skilltrade.business.facade.concrete.ConsultarCategoriaFachadaImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.dto.CategoriaDTO;

@RestController
@RequestMapping("skilltrade/api/v1/categoria")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public final class CategoriaController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);

   
    private ConsultarCategoriaFachadaImpl fachada;

    @GetMapping("/dummy")
    public CategoriaDTO dummy() {
        return CategoriaDTO.build();
    }

    @GetMapping
    public ResponseEntity<Response<CategoriaDTO>> consultar() {
        
    	CategoriaResponse categoriaResponse = CategoriaResponse.build();
        HttpStatus httpStatusResponse = HttpStatus.OK;

        try {
            final var categoriaDtoFilter = CategoriaDTO.build();
            
            fachada = new ConsultarCategoriaFachadaImpl();
            fachada.ejecutar(categoriaDtoFilter);
            
            final List<CategoriaDTO> datosCategoria = fachada.ejecutar(categoriaDtoFilter);
            categoriaResponse.setDatos(datosCategoria);
            categoriaResponse.getMensajes().add("Categorias consultadas exitosamente");
               
        } catch (final SkillTradeException exception) {
            logger.error("Error de negocio: ", exception);
            categoriaResponse.getMensajes().add(exception.getMensajeUsuario());
            httpStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            logger.error("Error inesperado: ", exception);
            categoriaResponse.getMensajes().add("Se ha presentado un problema inesperado");
            httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(categoriaResponse, httpStatusResponse);
    }

}
