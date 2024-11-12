package co.edu.uco.skilltrade.business.facade;

import java.util.List;

import co.edu.uco.skilltrade.dto.CategoriaDTO;

public interface ConsultarCategoriaPorNombreFachada {
	
	List<CategoriaDTO> ejecutar(CategoriaDTO categoria);
	
}
