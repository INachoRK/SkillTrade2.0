package co.edu.uco.skilltrade.data.dao.sql.azuresql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.concrete.EstadoCursoDTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.EstadoCursoDAO;
import co.edu.uco.skilltrade.data.dao.sql.SqlConnection;
import co.edu.uco.skilltrade.dto.EstadoCursoDTO;
import co.edu.uco.skilltrade.entity.EstadoCursoEntity;

public final class EstadoCursoAzureSqlDAO extends SqlConnection implements EstadoCursoDAO {

	public EstadoCursoAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final List<EstadoCursoEntity> consultar(EstadoCursoEntity entidad) {

		final List<EstadoCursoEntity> listaCategorias = new ArrayList<>();
        final StringBuilder sentenciaSql = new StringBuilder();
        

        sentenciaSql.append("SELECT nombre ");
        sentenciaSql.append("FROM EstadoCurso ");
        
       
        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {  
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
            	
                while (resultado.next()) {
                	EstadoCursoDTO estadoCursoTemp = EstadoCursoDTO.build();
                	estadoCursoTemp.setNombre(resultado.getString("nombre"));
                	EstadoCursoEntity estadoCurso = EstadoCursoDTOEntityAssembler.obtenerInstancia().ensamblarEntity(estadoCursoTemp);
					listaCategorias.add(estadoCurso); 
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
        
        return listaCategorias;
	}



	@Override
	public void crear(EstadoCursoEntity entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(EstadoCursoEntity entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean consultarLogin(EstadoCursoEntity entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
