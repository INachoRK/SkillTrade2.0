package co.edu.uco.skilltrade.data.dao.factory;


import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.CursoDAO;
import co.edu.uco.skilltrade.data.dao.SesionDAO;
import co.edu.uco.skilltrade.data.dao.UsuarioDAO;
import co.edu.uco.skilltrade.data.dao.factory.sql.azuresql.AzureSqlDAOFactory;
import co.edu.uco.skilltrade.data.dao.factory.enums.Factory;

public abstract class DAOFactory {
	

	public static final DAOFactory getFactory(final Factory factory){
		switch(factory){
			case AZURE_SQL -> {
				return new AzureSqlDAOFactory();
				}
			case SQL_SERVER -> {
				var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
				var mensajeTecnico = "No existe configurada una factoria de datos para una base de datos SQL Server";

				throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario);
				}
			default ->{
				return new AzureSqlDAOFactory();
			}
			}
		
		}

	protected abstract void obtenerConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract void cerrarConexion();

	public abstract CursoDAO getCursoDAO();
	
	public abstract SesionDAO getSesionDAO();
	
	public abstract UsuarioDAO getUsuarioDAO();

}