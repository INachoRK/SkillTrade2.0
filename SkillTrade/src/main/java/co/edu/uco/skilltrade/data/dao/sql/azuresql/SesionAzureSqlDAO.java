package co.edu.uco.skilltrade.data.dao.sql.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.SesionDAO;
import co.edu.uco.skilltrade.data.dao.sql.SqlConnection;
import co.edu.uco.skilltrade.entity.SesionEntity;

public final class SesionAzureSqlDAO extends SqlConnection implements SesionDAO {

	public SesionAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final SesionEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO Sesion");
		sentenciaSql.append("VALUES('?', '?', '?', '?')");
		
        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
            sentenciaPreparada.setString(2, entidad.getTitulo());
            sentenciaPreparada.setString(3, entidad.getDescripcion());
            sentenciaPreparada.setBytes(4, entidad.getVideo());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00026);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00021, entidad.getTitulo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }catch (final Exception exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00026);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00022, entidad.getTitulo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }

	}

	@Override
	public final void actualizar(final SesionEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("UPDATE Curso");
		sentenciaSql.append("SET Titulo = ''");
		sentenciaSql.append("WHERE id = ?");

	}

	public final void eliminar(final int id) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM Curso");
		sentenciaSql.append("WHERE id = ?");
	}

	@Override
	public final List<SesionEntity> consultar(SesionEntity entidad) {

		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("SELECT id, nombre");
		sentenciaSql.append("FROM Curso");
		sentenciaSql.append("ORDER BY nombre ASC");
		
		return null;
	}

	@Override
	public boolean consultarLogin(SesionEntity entidad) {
		// TODO Auto-generated method stub
		return false;
	}

}
