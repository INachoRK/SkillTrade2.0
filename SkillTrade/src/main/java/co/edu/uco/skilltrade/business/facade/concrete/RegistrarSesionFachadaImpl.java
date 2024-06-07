package co.edu.uco.skilltrade.business.facade.concrete;


import co.edu.uco.skilltrade.business.assembler.dto.concrete.SesionDTODomainAssembler;
import co.edu.uco.skilltrade.business.facade.RegistrarSesionFachada;
import co.edu.uco.skilltrade.business.usecase.impl.RegistrarSesionImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.BusinessSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;
import co.edu.uco.skilltrade.data.dao.factory.enums.Factory;
import co.edu.uco.skilltrade.dto.SesionDTO;

public class RegistrarSesionFachadaImpl implements RegistrarSesionFachada {
	
	private DAOFactory factory;
	
	public RegistrarSesionFachadaImpl() {
		factory = DAOFactory.getFactory(Factory.AZURE_SQL);
	}
	
	public final void ejecutar(final SesionDTO sesion) {
		try {
			factory.iniciarTransaccion();
			
			var sesionDomain = SesionDTODomainAssembler.obtenerInstancia().ensamblarDominio(sesion);
			
			RegistrarSesionImpl useCase = new RegistrarSesionImpl(factory);
			useCase.ejecutar(sesionDomain);
			
			factory.confirmarTransaccion();
		}catch (final SkillTradeException excepcion) {
			factory.cancelarTransaccion();
			throw excepcion;
		}catch (final Exception excepcion) {
			factory.cancelarTransaccion();
			
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00028);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00029);
		
			throw new BusinessSkillTradeException(mensajeTecnico, mensajeUsuario);
			
		} finally {
			factory.cerrarConexion();
		}
	}

}
