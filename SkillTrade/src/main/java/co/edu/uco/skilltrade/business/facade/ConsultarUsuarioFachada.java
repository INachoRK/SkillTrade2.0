package co.edu.uco.skilltrade.business.facade;

import java.util.List;

import co.edu.uco.skilltrade.dto.UsuarioDTO;

public interface ConsultarUsuarioFachada {
	
	List<UsuarioDTO> ejecutar(UsuarioDTO usuario);
	
	boolean ejecutarLogin(UsuarioDTO usuario);
	
}
