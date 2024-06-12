package co.edu.uco.skilltrade.data.dao.sql.azuresql;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.concrete.CursoDTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.CursoDAO;
import co.edu.uco.skilltrade.data.dao.sql.SqlConnection;
import co.edu.uco.skilltrade.dto.CursoDTO;
import co.edu.uco.skilltrade.entity.CursoEntity;

public final class CursoAzureSqlDAO extends SqlConnection implements CursoDAO {

	public CursoAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final CursoEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO dbo.Curso ");
		sentenciaSql.append("(titulo, descripcion, categoria) ");
		sentenciaSql.append("VALUES (?, ?, ?)");
				
        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
        	sentenciaPreparada.setString(1, entidad.getTitulo());
            sentenciaPreparada.setString(2, entidad.getDescripcion());
            sentenciaPreparada.setString(3, entidad.getCategoria());
            
            
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00021, entidad.getTitulo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }catch (final Exception exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00022, entidad.getTitulo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }

	}

	@Override
	public final void actualizar(final CursoEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("UPDATE Curso");
		sentenciaSql.append("SET Titulo = ?");
		sentenciaSql.append("WHERE id = ?");
		
		try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
        	sentenciaPreparada.setString(1, entidad.getTitulo());
            
            

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00021, entidad.getTitulo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }catch (final Exception exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00022, entidad.getTitulo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }

	}

	public final void eliminar(final int id) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM Curso");
		sentenciaSql.append("WHERE id = 1");
	}

	@Override
	public final List<CursoEntity> consultar(CursoEntity entidad) {
		final List<CursoEntity> listaCursos = new ArrayList<>();
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("SELECT titulo, descripcion, categoria ");
		sentenciaSql.append("FROM dbo.Curso");
		
		try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {  
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
            	
                while (resultado.next()) {
                	CursoDTO cursoTemp = CursoDTO.build();
                	cursoTemp.setTitulo(resultado.getString("titulo")).setDescripcion(resultado.getString("descripcion"))
                	.setCategoria(resultado.getString("categoria"));
                	CursoEntity curso = CursoDTOEntityAssembler.obtenerInstancia().ensamblarEntity(cursoTemp);
					listaCursos.add(curso); 
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00040);
            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00041);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00042);
	
            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }
        
        return listaCursos;
	}

	@Override
	public boolean consultarLogin(CursoEntity entidad) {
		// TODO Auto-generated method stub
		return false;
	}

}
