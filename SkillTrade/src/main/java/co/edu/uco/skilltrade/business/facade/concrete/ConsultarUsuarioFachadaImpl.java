package co.edu.uco.skilltrade.business.facade.concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.skilltrade.business.assembler.dto.concrete.UsuarioDTODomainAssembler;
import co.edu.uco.skilltrade.business.facade.ConsultarUsuarioFachada;
import co.edu.uco.skilltrade.business.usecase.ConsultarUsuario;
import co.edu.uco.skilltrade.business.usecase.impl.ConsultarUsuarioImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.BusinessSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;
import co.edu.uco.skilltrade.data.dao.factory.enums.Factory;
import co.edu.uco.skilltrade.dto.UsuarioDTO;

@Service
public class ConsultarUsuarioFachadaImpl implements ConsultarUsuarioFachada {
    
    private DAOFactory factory;
    
    public ConsultarUsuarioFachadaImpl() {
        factory = DAOFactory.getFactory(Factory.AZURE_SQL);
    }
    
    public final List<UsuarioDTO> ejecutar(final UsuarioDTO usuario) {
        try {
            var usuarioDomain = UsuarioDTODomainAssembler.obtenerInstancia().ensamblarDominio(usuario);

            final ConsultarUsuario useCase = new ConsultarUsuarioImpl(factory);
            var resultados = useCase.ejecutar(usuarioDomain);
            return UsuarioDTODomainAssembler.obtenerInstancia()
                    .ensamblarListaDTO(resultados);
        } catch (final SkillTradeException excepcion) {
            
            throw excepcion;
        } catch (final Exception excepcion) {
            
            
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00032);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00033);
        
            throw new BusinessSkillTradeException(mensajeTecnico, mensajeUsuario);
            
        } 
    }

	@Override
	public boolean ejecutarLogin(UsuarioDTO usuario) {
		try {
            var usuarioDomain = UsuarioDTODomainAssembler.obtenerInstancia().ensamblarDominio(usuario);

            final ConsultarUsuario useCase = new ConsultarUsuarioImpl(factory);
            var resultados = useCase.ejecutarLogin(usuarioDomain);
            return resultados;
        } catch (final SkillTradeException excepcion) {
            
            throw excepcion;
        } catch (final Exception excepcion) {
            
            
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00032);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00033);
        
            throw new BusinessSkillTradeException(mensajeTecnico, mensajeUsuario);
            
        } 
	}
}


