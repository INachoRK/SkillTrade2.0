package co.edu.uco.skilltrade.business.facade.concrete;


import co.edu.uco.skilltrade.business.assembler.dto.concrete.CursoDTODomainAssembler;
import co.edu.uco.skilltrade.business.facade.RegistrarCursoFachada;
import co.edu.uco.skilltrade.business.usecase.RegistrarCurso;
import co.edu.uco.skilltrade.business.usecase.impl.RegistrarCursoImpl;
import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.BusinessSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;
import co.edu.uco.skilltrade.data.dao.factory.enums.Factory;
import co.edu.uco.skilltrade.dto.CursoDTO;

public class RegistrarCursoFachadaImpl implements RegistrarCursoFachada {
	
	private DAOFactory factory;
	
	public RegistrarCursoFachadaImpl() {
		factory = DAOFactory.getFactory(Factory.AZURE_SQL);
	}
	
	public final void ejecutar(final CursoDTO curso) {
		try {
			factory.iniciarTransaccion();
			
			var cursoDomain = CursoDTODomainAssembler.obtenerInstancia().ensamblarDominio(curso);
			
			RegistrarCurso useCase = new RegistrarCursoImpl(factory);
			useCase.ejecutar(cursoDomain);
			
			factory.confirmarTransaccion();
		}catch (final SkillTradeException excepcion) {
			factory.cancelarTransaccion();
			throw excepcion;
		}catch (final Exception excepcion) {
			factory.cancelarTransaccion();
			
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00030);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
		
			throw new BusinessSkillTradeException(mensajeTecnico, mensajeUsuario);
			
		} finally {
			factory.cerrarConexion();
		}
	}

}
