package co.edu.uco.skilltrade.business.facade;

import java.util.List;

import co.edu.uco.skilltrade.dto.CategoriaDTO;

public interface ConsultarCategoriaFachada {
	
	List<CategoriaDTO> ejecutar(CategoriaDTO categoria);
	
}
