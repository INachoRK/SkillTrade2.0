package co.edu.uco.skilltrade.business.usecase;

import java.util.List;


import co.edu.uco.skilltrade.business.domain.CursoDomain;

public interface ConsultarCurso {
	List<CursoDomain> ejecutar(CursoDomain usuario);
	
	
}
