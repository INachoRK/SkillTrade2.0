package co.edu.uco.skilltrade.business.assembler.entity.concrete;

import java.util.ArrayList;


import java.util.List;

import co.edu.uco.skilltrade.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.CategoriaDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.entity.CategoriaEntity;

public class CategoriaEntityDomainAssembler implements EntityDomainAssembler<CategoriaDomain, CategoriaEntity> {
	
	private static final EntityDomainAssembler<CategoriaDomain, CategoriaEntity> instancia = new CategoriaEntityDomainAssembler();
	
	private CategoriaEntityDomainAssembler() {
        super();
    }
	
	public static final EntityDomainAssembler<CategoriaDomain, CategoriaEntity> obtenerInstancia(){
        return instancia;
    }

	@Override
    public final CategoriaDomain ensamblarDominio(final CategoriaEntity entidad) {
        var categoriaEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad,CategoriaEntity.build());
        return CategoriaDomain.build(categoriaEntityTmp.getId(), categoriaEntityTmp.getNombre());
    }

    @Override
    public final CategoriaEntity ensamblarEntidad(final CategoriaDomain dominio) {
        var categoriaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CategoriaDomain.build());
        return CategoriaEntity.build(categoriaDomainTmp.getId(), categoriaDomainTmp.getNombre());
    }

    @Override
    public final List<CategoriaDomain> ensamblarListaDominios(List<CategoriaEntity> listaEntidades) {
        var listaEntidaesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<CategoriaEntity>());
        var resultados = new ArrayList<CategoriaDomain>();

        for (CategoriaEntity categoriaEntity : listaEntidaesTmp) {
            var categoriaDomainTmp = ensamblarDominio(categoriaEntity);
            resultados.add(categoriaDomainTmp);
        }
        return resultados;
    }
	
}
