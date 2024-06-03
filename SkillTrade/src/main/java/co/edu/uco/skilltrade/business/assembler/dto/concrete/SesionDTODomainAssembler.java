package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTODomainAssembler;

import co.edu.uco.skilltrade.business.domain.CursoDomain;
import co.edu.uco.skilltrade.business.domain.SesionDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.CursoDTO;
import co.edu.uco.skilltrade.dto.SesionDTO;

public class SesionDTODomainAssembler implements DTODomainAssembler<SesionDomain, SesionDTO > {

	private static final DTODomainAssembler<SesionDomain, SesionDTO> instancia =
			new SesionDTODomainAssembler();
	
	private static final DTODomainAssembler<CursoDomain, CursoDTO> cursoAssembler = CursoDTODomainAssembler
            .obtenerInstancia();
	
	private SesionDTODomainAssembler() {
		super ();
	}
	
	public static final DTODomainAssembler<SesionDomain, SesionDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final SesionDomain ensamblarDominio(final SesionDTO dto) {
		var sesionDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, SesionDTO.build());
		var cursoDomain = cursoAssembler.ensamblarDominio(sesionDtoTmp.getCurso());
		
		return SesionDomain.crear(sesionDtoTmp.getId(), sesionDtoTmp.getTitulo(), sesionDtoTmp.getDescripcion(), sesionDtoTmp.getVideo(), cursoDomain);
	}

	@Override
	public final SesionDTO ensamblarDTO(final SesionDomain dominio) {
		var sesionDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, SesionDomain.crear());
		var cursoDTO = cursoAssembler.ensamblarDTO(sesionDomainTmp.getCurso());
		
		return SesionDTO.build().setId(sesionDomainTmp.getId()).setTitulo(sesionDomainTmp.getTitulo()).
				setDescripcion(sesionDomainTmp.getDescripcion()).setVideo(sesionDomainTmp.getVideo()).setCurso(cursoDTO);
	}
	
	@Override
    public final List<SesionDTO> ensamblarListaDTO(List<SesionDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<SesionDomain>());
        var resultados = new ArrayList<SesionDTO>();

        for (SesionDomain sesionDomain : listaDominiosTmp) {
            var sesionDtoTmp = ensamblarDTO(sesionDomain);
            resultados.add(sesionDtoTmp);
        }
        return resultados;
    }

}
