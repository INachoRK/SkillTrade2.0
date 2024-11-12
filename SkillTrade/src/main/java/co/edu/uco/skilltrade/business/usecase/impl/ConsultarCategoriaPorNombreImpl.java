package co.edu.uco.skilltrade.business.usecase.impl;

import java.util.List;

import co.edu.uco.skilltrade.business.assembler.entity.concrete.CategoriaEntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.CategoriaDomain;
import co.edu.uco.skilltrade.business.usecase.ConsultarCategoriaPorNombre;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;

public class ConsultarCategoriaPorNombreImpl implements ConsultarCategoriaPorNombre {

	private final DAOFactory factory;
	
	public ConsultarCategoriaPorNombreImpl(final DAOFactory factory){
		this.factory = factory;
	}

	@Override
    public final List<CategoriaDomain> ejecutar(final CategoriaDomain categoria) {
        var categoriaEntity = CategoriaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(categoria);
        var resultados = factory.getCategoriaDAO().consultarPorNombre(categoriaEntity);

        return CategoriaEntityDomainAssembler.obtenerInstancia().ensamblarListaDominios(resultados);
	}

}
