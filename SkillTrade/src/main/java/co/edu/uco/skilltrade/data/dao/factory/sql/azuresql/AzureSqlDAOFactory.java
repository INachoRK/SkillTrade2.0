package co.edu.uco.skilltrade.data.dao.factory.sql.azuresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.crosscutting.helpers.SQLHelper;
import co.edu.uco.skilltrade.data.dao.CursoDAO;
import co.edu.uco.skilltrade.data.dao.SesionDAO;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;
import co.edu.uco.skilltrade.data.dao.sql.azuresql.CursoAzureSqlDAO;
import co.edu.uco.skilltrade.data.dao.sql.azuresql.SesionAzureSqlDAO;

public final class AzureSqlDAOFactory extends DAOFactory {

	private Connection connection;

	public AzureSqlDAOFactory() {
		obtenerConexion();
	}

	@Override
	protected void obtenerConexion() {
		final String connectionUrl = "jdbc:sqlserver://skilltrade-server.database.windows.net:1433;databaseName=STDB";
		final String usuario = "Administrador";
        final String contraseña = "Admin123";
		try {
			connection = DriverManager.getConnection(connectionUrl, usuario, contraseña);
			System.out.println(connection);
		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, excepcion);
		}
	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(connection);

	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(connection);

	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(connection);

	}

	@Override
	public void cerrarConexion() {
		SQLHelper.close(connection);

	}

	@Override
	public CursoDAO getCursoDAO() {
		return new CursoAzureSqlDAO(connection);
	}

	@Override
	public SesionDAO getSesionDAO() {
		return new SesionAzureSqlDAO(connection);
	}

}