package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;



import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.CursoDTO;
import co.edu.uco.skilltrade.entity.CursoEntity;

public class CursoDTOEntityAssembler implements DTOEntityAssembler<CursoEntity, CursoDTO> {

	private static final DTOEntityAssembler<CursoEntity, CursoDTO> instancia =
			new CursoDTOEntityAssembler();
	
	private CursoDTOEntityAssembler() {
		super ();
	}
	
	public static final DTOEntityAssembler<CursoEntity, CursoDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final CursoEntity ensamblarEntity(final CursoDTO dto) {
		var cursoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, CursoDTO.build());
		return CursoEntity.build(cursoDtoTmp.getId(), cursoDtoTmp.getTitulo(), cursoDtoTmp.getDescripcion(), cursoDtoTmp.getCategoria());
	}

	@Override
	public final CursoDTO ensamblarDTO(final CursoEntity entidad) {
		var cursoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, CursoEntity.build());
		return CursoDTO.build().setTitulo(cursoEntityTmp.getTitulo()).setDescripcion(cursoEntityTmp.getDescripcion())
				.setCategoria(cursoEntityTmp.getCategoria());
	}
	
	@Override
    public final List<CursoEntity> ensamblarListaDTO(List<CursoDTO> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<CursoDTO>());
        var resultados = new ArrayList<CursoEntity>();

        for (CursoDTO cursoDTO : listaDominiosTmp) {
            var cursoEntityTmp = ensamblarEntity(cursoDTO);
            resultados.add(cursoEntityTmp);
        }
        return resultados;
    }


}
