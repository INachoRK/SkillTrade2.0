package co.edu.uco.skilltrade.data.dao.sql;

import java.sql.Connection;

import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.crosscutting.helpers.SQLHelper;

public class SqlConnection {

	private Connection connection;

	protected SqlConnection(final Connection connection) {
		 setConnection(connection);

	}

	private final void setConnection(final Connection connection) {
		 if(!SQLHelper.isOpen(connection)){
	            var mensajeUsuario= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
	            var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023);

	            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario);
	        }
	        this.connection = connection;

	}

	protected final Connection getConnection() {
		return connection;
	}
}
