package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.EstadoCursoDTO;
import co.edu.uco.skilltrade.entity.EstadoCursoEntity;

public class EstadoCursoDTOEntityAssembler implements DTOEntityAssembler<EstadoCursoEntity, EstadoCursoDTO> {

	private static final DTOEntityAssembler<EstadoCursoEntity, EstadoCursoDTO> instancia =
			new EstadoCursoDTOEntityAssembler();
	
	private EstadoCursoDTOEntityAssembler() {
		super ();
	}
	
	public static final DTOEntityAssembler<EstadoCursoEntity, EstadoCursoDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final EstadoCursoEntity ensamblarEntity(final EstadoCursoDTO dto) {
		var estadoCursoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, EstadoCursoDTO.build());
		return EstadoCursoEntity.build(estadoCursoDtoTmp.getId(), estadoCursoDtoTmp.getNombre());
	}

	@Override
	public final EstadoCursoDTO ensamblarDTO(final EstadoCursoEntity entidad) {
		var estadoCursoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, EstadoCursoEntity.build());
		return EstadoCursoDTO.build().setId(estadoCursoEntityTmp.getId()).setNombre(estadoCursoEntityTmp.getNombre());
	}
	
	@Override
    public final List<EstadoCursoEntity> ensamblarListaDTO(List<EstadoCursoDTO> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<EstadoCursoDTO>());
        var resultados = new ArrayList<EstadoCursoEntity>();

        for (EstadoCursoDTO estadoCursoDTO : listaDominiosTmp) {
            var estadoCursoEntityTmp = ensamblarEntity(estadoCursoDTO);
            resultados.add(estadoCursoEntityTmp);
        }
        return resultados;
    }


}
