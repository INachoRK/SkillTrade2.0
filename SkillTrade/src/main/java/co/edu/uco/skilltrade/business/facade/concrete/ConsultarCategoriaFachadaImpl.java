package co.edu.uco.skilltrade.business.facade.concrete;

import java.util.List;



import org.springframework.stereotype.Service;

import co.edu.uco.skilltrade.business.assembler.dto.concrete.CategoriaDTODomainAssembler;
import co.edu.uco.skilltrade.business.facade.ConsultarCategoriaFachada;
import co.edu.uco.skilltrade.business.usecase.ConsultarCategoria;
import co.edu.uco.skilltrade.business.usecase.impl.ConsultarCategoriaImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.BusinessSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;
import co.edu.uco.skilltrade.data.dao.factory.enums.Factory;
import co.edu.uco.skilltrade.dto.CategoriaDTO;

@Service
public class ConsultarCategoriaFachadaImpl implements ConsultarCategoriaFachada {
    
    private DAOFactory factory;
    
    public ConsultarCategoriaFachadaImpl() {
        factory = DAOFactory.getFactory(Factory.AZURE_SQL);
    }
    
    public final List<CategoriaDTO> ejecutar(final CategoriaDTO categoria) {
        try {
            var categoriaDomain = CategoriaDTODomainAssembler.obtenerInstancia().ensamblarDominio(categoria);

            final ConsultarCategoria useCase = new ConsultarCategoriaImpl(factory);
            var resultados = useCase.ejecutar(categoriaDomain);
            return CategoriaDTODomainAssembler.obtenerInstancia()
                    .ensamblarListaDTO(resultados);
        } catch (final SkillTradeException excepcion) {
            
            throw excepcion;
        } catch (final Exception excepcion) {
            
            
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00041);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00042);
        
            throw new BusinessSkillTradeException(mensajeTecnico, mensajeUsuario);
            
        } 
    }

}


