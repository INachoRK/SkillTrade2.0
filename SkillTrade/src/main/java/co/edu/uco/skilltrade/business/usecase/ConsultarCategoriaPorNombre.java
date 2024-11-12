package co.edu.uco.skilltrade.business.usecase;

import java.util.List;

import co.edu.uco.skilltrade.business.domain.CategoriaDomain;

public interface ConsultarCategoriaPorNombre {
	
	List<CategoriaDomain> ejecutar(CategoriaDomain usuario);
	
	
}
