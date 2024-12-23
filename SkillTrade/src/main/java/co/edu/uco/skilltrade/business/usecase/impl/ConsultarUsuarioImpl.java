package co.edu.uco.skilltrade.business.usecase.impl;

import java.util.List;

import co.edu.uco.skilltrade.business.assembler.entity.concrete.UsuarioEntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.UsuarioDomain;
import co.edu.uco.skilltrade.business.usecase.ConsultarUsuario;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;

public class ConsultarUsuarioImpl implements ConsultarUsuario {

	private final DAOFactory factory;
	
	public ConsultarUsuarioImpl(final DAOFactory factory){
		this.factory = factory;
	}

	@Override
    public final List<UsuarioDomain> ejecutar(final UsuarioDomain usuario) {
        var usuarioEntity = UsuarioEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(usuario);
        var resultados = factory.getUsuarioDAO().consultar(usuarioEntity);

        return UsuarioEntityDomainAssembler.obtenerInstancia().ensamblarListaDominios(resultados);
    }

	@Override
	public boolean ejecutarLogin(UsuarioDomain usuario) {
		var usuarioEntity = UsuarioEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(usuario);
        var resultados = factory.getUsuarioDAO().consultarLogin(usuarioEntity);

        return resultados;
	}
	
	 
}
