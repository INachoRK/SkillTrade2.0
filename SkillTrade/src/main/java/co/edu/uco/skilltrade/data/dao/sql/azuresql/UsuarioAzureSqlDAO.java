package co.edu.uco.skilltrade.data.dao.sql.azuresql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.concrete.UsuarioDTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.exceptions.custom.DataSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.data.dao.UsuarioDAO;
import co.edu.uco.skilltrade.data.dao.sql.SqlConnection;
import co.edu.uco.skilltrade.dto.UsuarioDTO;
import co.edu.uco.skilltrade.entity.UsuarioEntity;

public final class UsuarioAzureSqlDAO extends SqlConnection implements UsuarioDAO {

	public UsuarioAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final UsuarioEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO dbo.Usuario ");
		sentenciaSql.append("(correo, nombreUsuario, contrasena) ");
		sentenciaSql.append("VALUES (?, ?, ?)");
				
        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
        	sentenciaPreparada.setString(1, entidad.getCorreo());
            sentenciaPreparada.setString(2, entidad.getNombreUsuario());
            sentenciaPreparada.setString(3, entidad.getPassword());
           
            

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00021, entidad.getCorreo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }catch (final Exception exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00022, entidad.getCorreo());

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }

	}

	@Override
	public final void actualizar(final UsuarioEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("UPDATE dbo.Usuario");
		sentenciaSql.append("SET Titulo = ''");
		sentenciaSql.append("WHERE id = 1");

	}

	public final void eliminar(final String correo) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM dbo.Usuario");
		sentenciaSql.append("WHERE correo = ?");
		
	}

	@Override
    public List<UsuarioEntity> consultar(final UsuarioEntity entidad) {
        final List<UsuarioEntity> listaUsuarios = new ArrayList<>();
        final StringBuilder sentenciaSql = new StringBuilder();
        

        sentenciaSql.append("SELECT correoUsuario, nombreUsuario, contraseña ");
        sentenciaSql.append("FROM usuario ");
        sentenciaSql.append("WHERE correo = ?");
        

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {  
        	sentenciaPreparada.setString(1, entidad.getCorreo());
        	
        	
            
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
            	
                if (resultado.next()) {
                	UsuarioDTO usuarioTemp = UsuarioDTO.build();
                	usuarioTemp.setCorreo(resultado.getString("correo")).setNombreUsuario(resultado.getString("nombreUsuario")).setPassword(resultado.getString("contrasena"));
                	UsuarioEntity usuario = UsuarioDTOEntityAssembler.obtenerInstancia().ensamblarEntity(usuarioTemp); 
                	listaUsuarios.add(usuario);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00036);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00029);
            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00038);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }
        
        return listaUsuarios;
    }

	@Override
	public void eliminar(int id) {
		
	}

	@Override
	public boolean consultarLogin(UsuarioEntity entidad) {
		final StringBuilder sentenciaSql = new StringBuilder();
        

        sentenciaSql.append("SELECT correo, contraseña ");
        sentenciaSql.append("FROM skilltrade.usuario ");
        sentenciaSql.append("WHERE correo = ? AND contraseña = ?");
        

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {  
        	sentenciaPreparada.setString(1, entidad.getCorreo());
        	sentenciaPreparada.setString(2, entidad.getPassword());
        	
        	
            
        	try (ResultSet resultSet = sentenciaPreparada.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00036);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00029);
            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00038);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);

            throw new DataSkillTradeException(mensajeTecnico, mensajeUsuario, exception);
        }
        
	}

}

	
