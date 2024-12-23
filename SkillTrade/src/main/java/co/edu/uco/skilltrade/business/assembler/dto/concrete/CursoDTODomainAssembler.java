package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTODomainAssembler;

import co.edu.uco.skilltrade.business.domain.CursoDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.CursoDTO;

public class CursoDTODomainAssembler implements DTODomainAssembler<CursoDomain, CursoDTO > {

	private static final DTODomainAssembler<CursoDomain, CursoDTO> instancia =
			new CursoDTODomainAssembler();
	
	private CursoDTODomainAssembler() {
		super ();
	}
	
	public static final DTODomainAssembler<CursoDomain, CursoDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final CursoDomain ensamblarDominio(final CursoDTO dto) {
		var cursoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new CursoDTO());
		return CursoDomain.crear(cursoDtoTmp.getId(), cursoDtoTmp.getTitulo(), cursoDtoTmp.getDescripcion(), CategoriaDTODomainAssembler.obtenerInstancia().ensamblarDominio(cursoDtoTmp.getCategoria())
				, UsuarioDTODomainAssembler.obtenerInstancia().ensamblarDominio(cursoDtoTmp.getUsuario()), EstadoCursoDTODomainAssembler.obtenerInstancia().ensamblarDominio(cursoDtoTmp.getEstado()));
	}

	@Override
	public final CursoDTO ensamblarDTO(final CursoDomain dominio) {
		var cursoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CursoDomain.crear());
		return CursoDTO.build().setId(cursoDomainTmp.getId()).setTitulo(cursoDomainTmp.getTitulo()).
				setDescripcion(cursoDomainTmp.getDescripcion()).setCategoria(CategoriaDTODomainAssembler.obtenerInstancia().ensamblarDTO(cursoDomainTmp.getCategoria()))
				.setUsuario(UsuarioDTODomainAssembler.obtenerInstancia().ensamblarDTO(cursoDomainTmp.getUsuario())).setEstado(EstadoCursoDTODomainAssembler.obtenerInstancia().ensamblarDTO(cursoDomainTmp.getEstado()));
	}
	
	@Override
    public final List<CursoDTO> ensamblarListaDTO(List<CursoDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<CursoDomain>());
        var resultados = new ArrayList<CursoDTO>();

        for (CursoDomain cursoDomain : listaDominiosTmp) {
            var cursoDtoTmp = ensamblarDTO(cursoDomain);
            resultados.add(cursoDtoTmp);
        }
        return resultados;
    }

}
