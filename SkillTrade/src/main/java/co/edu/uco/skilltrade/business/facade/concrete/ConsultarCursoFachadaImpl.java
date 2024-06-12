package co.edu.uco.skilltrade.business.facade.concrete;

import java.util.List;



import org.springframework.stereotype.Service;

import co.edu.uco.skilltrade.business.assembler.dto.concrete.CursoDTODomainAssembler;
import co.edu.uco.skilltrade.business.facade.ConsultarCursoFachada;
import co.edu.uco.skilltrade.business.usecase.ConsultarCurso;
import co.edu.uco.skilltrade.business.usecase.impl.ConsultarCursoImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.BusinessSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;
import co.edu.uco.skilltrade.data.dao.factory.enums.Factory;
import co.edu.uco.skilltrade.dto.CursoDTO;

@Service
public class ConsultarCursoFachadaImpl implements ConsultarCursoFachada {
    
    private DAOFactory factory;
    
    public ConsultarCursoFachadaImpl() {
        factory = DAOFactory.getFactory(Factory.AZURE_SQL);
    }
    
    public final List<CursoDTO> ejecutar(final CursoDTO curso) {
        try {
            var cursoDomain = CursoDTODomainAssembler.obtenerInstancia().ensamblarDominio(curso);

            final ConsultarCurso useCase = new ConsultarCursoImpl(factory);
            var resultados = useCase.ejecutar(cursoDomain);
            return CursoDTODomainAssembler.obtenerInstancia()
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


