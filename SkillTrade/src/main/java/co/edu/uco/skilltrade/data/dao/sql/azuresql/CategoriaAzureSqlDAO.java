package co.edu.uco.skilltrade.data.dao.sql.azuresql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.concrete.CategoriaDTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.CategoriaDAO;
import co.edu.uco.skilltrade.data.dao.sql.SqlConnection;
import co.edu.uco.skilltrade.dto.CategoriaDTO;
import co.edu.uco.skilltrade.entity.CategoriaEntity;

public final class CategoriaAzureSqlDAO extends SqlConnection implements CategoriaDAO {

	public CategoriaAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final List<CategoriaEntity> consultar(CategoriaEntity entidad) {

		final List<CategoriaEntity> listaCategorias = new ArrayList<>();
        final StringBuilder sentenciaSql = new StringBuilder();
        

        sentenciaSql.append("SELECT nombre ");
        sentenciaSql.append("FROM dbo.Categoria ");
        
       
        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {  
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
            	
                while (resultado.next()) {
                	CategoriaDTO categoriaTemp = CategoriaDTO.build();
                	categoriaTemp.setNombre(resultado.getString("nombre"));
					CategoriaEntity categoria = CategoriaDTOEntityAssembler.obtenerInstancia().ensamblarEntity(categoriaTemp);
					listaCategorias.add(categoria); 
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
	public void crear(CategoriaEntity entidad) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actualizar(CategoriaEntity entidad) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean consultarLogin(CategoriaEntity entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
