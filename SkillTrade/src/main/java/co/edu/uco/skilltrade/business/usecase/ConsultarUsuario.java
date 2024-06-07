package co.edu.uco.skilltrade.business.usecase;

import java.util.List;

import co.edu.uco.skilltrade.business.domain.UsuarioDomain;

public interface ConsultarUsuario {
	List<UsuarioDomain> ejecutar(UsuarioDomain usuario);
	
	boolean ejecutarLogin(UsuarioDomain usuario);
}
