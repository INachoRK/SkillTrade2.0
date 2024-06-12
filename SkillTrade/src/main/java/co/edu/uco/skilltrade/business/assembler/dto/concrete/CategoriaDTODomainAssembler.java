package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTODomainAssembler;

import co.edu.uco.skilltrade.business.domain.CategoriaDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.CategoriaDTO;

public class CategoriaDTODomainAssembler implements DTODomainAssembler<CategoriaDomain, CategoriaDTO > {

	private static final DTODomainAssembler<CategoriaDomain, CategoriaDTO> instancia =
			new CategoriaDTODomainAssembler();
	
	private CategoriaDTODomainAssembler() {
		super ();
	}
	
	public static final DTODomainAssembler<CategoriaDomain, CategoriaDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final CategoriaDomain ensamblarDominio(final CategoriaDTO dto) {
		var categoriaDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, CategoriaDTO.build());
		return CategoriaDomain.build(categoriaDtoTmp.getId(), categoriaDtoTmp.getNombre());
	}

	@Override
	public final CategoriaDTO ensamblarDTO(final CategoriaDomain dominio) {
		var categoriaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CategoriaDomain.build());
		return CategoriaDTO.build().setId(categoriaDomainTmp.getId()).setNombre(categoriaDomainTmp.getNombre());
	}
	
	@Override
    public final List<CategoriaDTO> ensamblarListaDTO(List<CategoriaDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<CategoriaDomain>());
        var resultados = new ArrayList<CategoriaDTO>();

        for (CategoriaDomain categoriaDomain : listaDominiosTmp) {
            var categoriaDtoTmp = ensamblarDTO(categoriaDomain);
            resultados.add(categoriaDtoTmp);
        }
        return resultados;
    }

}
