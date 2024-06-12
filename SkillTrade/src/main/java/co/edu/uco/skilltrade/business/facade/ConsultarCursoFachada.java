package co.edu.uco.skilltrade.business.facade;

import java.util.List;


import co.edu.uco.skilltrade.dto.CursoDTO;

public interface ConsultarCursoFachada {
	
	List<CursoDTO> ejecutar(CursoDTO categoria);
	
}
