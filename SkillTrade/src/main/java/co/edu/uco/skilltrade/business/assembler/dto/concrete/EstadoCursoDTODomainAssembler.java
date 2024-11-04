package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTODomainAssembler;

import co.edu.uco.skilltrade.business.domain.EstadoCursoDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.EstadoCursoDTO;

public class EstadoCursoDTODomainAssembler implements DTODomainAssembler<EstadoCursoDomain, EstadoCursoDTO > {

	private static final DTODomainAssembler<EstadoCursoDomain, EstadoCursoDTO> instancia =
			new EstadoCursoDTODomainAssembler();
	
	private EstadoCursoDTODomainAssembler() {
		super ();
	}
	
	public static final DTODomainAssembler<EstadoCursoDomain, EstadoCursoDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final EstadoCursoDomain ensamblarDominio(final EstadoCursoDTO dto) {
		var estadoCursoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, EstadoCursoDTO.build());
		return EstadoCursoDomain.build(estadoCursoDtoTmp.getId(), estadoCursoDtoTmp.getNombre());
	}

	@Override
	public final EstadoCursoDTO ensamblarDTO(final EstadoCursoDomain dominio) {
		var estadoCursoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, EstadoCursoDomain.build());
		return EstadoCursoDTO.build().setId(estadoCursoDomainTmp.getId()).setNombre(estadoCursoDomainTmp.getNombre());
	}
	
	@Override
    public final List<EstadoCursoDTO> ensamblarListaDTO(List<EstadoCursoDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<EstadoCursoDomain>());
        var resultados = new ArrayList<EstadoCursoDTO>();

        for (EstadoCursoDomain estadoCursoDomain : listaDominiosTmp) {
            var estadoCursoDtoTmp = ensamblarDTO(estadoCursoDomain);
            resultados.add(estadoCursoDtoTmp);
        }
        return resultados;
    }

}
