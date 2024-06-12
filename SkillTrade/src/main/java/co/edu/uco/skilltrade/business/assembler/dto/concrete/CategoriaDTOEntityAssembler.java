package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;



import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.CategoriaDTO;
import co.edu.uco.skilltrade.entity.CategoriaEntity;

public class CategoriaDTOEntityAssembler implements DTOEntityAssembler<CategoriaEntity, CategoriaDTO> {

	private static final DTOEntityAssembler<CategoriaEntity, CategoriaDTO> instancia =
			new CategoriaDTOEntityAssembler();
	
	private CategoriaDTOEntityAssembler() {
		super ();
	}
	
	public static final DTOEntityAssembler<CategoriaEntity, CategoriaDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final CategoriaEntity ensamblarEntity(final CategoriaDTO dto) {
		var categoriaDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, CategoriaDTO.build());
		return CategoriaEntity.build(categoriaDtoTmp.getId(), categoriaDtoTmp.getNombre());
	}

	@Override
	public final CategoriaDTO ensamblarDTO(final CategoriaEntity entidad) {
		var categoriaEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, CategoriaEntity.build());
		return CategoriaDTO.build().setId(categoriaEntityTmp.getId()).setNombre(categoriaEntityTmp.getNombre());
	}
	
	@Override
    public final List<CategoriaEntity> ensamblarListaDTO(List<CategoriaDTO> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<CategoriaDTO>());
        var resultados = new ArrayList<CategoriaEntity>();

        for (CategoriaDTO usuarioDTO : listaDominiosTmp) {
            var categoriaEntityTmp = ensamblarEntity(usuarioDTO);
            resultados.add(categoriaEntityTmp);
        }
        return resultados;
    }


}
