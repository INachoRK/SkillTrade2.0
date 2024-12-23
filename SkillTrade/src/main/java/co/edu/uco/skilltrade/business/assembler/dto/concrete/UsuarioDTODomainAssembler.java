package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTODomainAssembler;

import co.edu.uco.skilltrade.business.domain.UsuarioDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.UsuarioDTO;

public class UsuarioDTODomainAssembler implements DTODomainAssembler<UsuarioDomain, UsuarioDTO > {

	private static final DTODomainAssembler<UsuarioDomain, UsuarioDTO> instancia =
			new UsuarioDTODomainAssembler();
	
	private UsuarioDTODomainAssembler() {
		super ();
	}
	
	public static final DTODomainAssembler<UsuarioDomain, UsuarioDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final UsuarioDomain ensamblarDominio(final UsuarioDTO dto) {
		var usuarioDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, UsuarioDTO.build());
		return UsuarioDomain.crear(usuarioDtoTmp.getId(), usuarioDtoTmp.getCorreo(), usuarioDtoTmp.getNombreUsuario(), usuarioDtoTmp.getPassword());
	}

	@Override
	public final UsuarioDTO ensamblarDTO(final UsuarioDomain dominio) {
		var usuarioDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, UsuarioDomain.build());
		return UsuarioDTO.build().setId(usuarioDomainTmp.getId()).setCorreo(usuarioDomainTmp.getCorreo()).setNombreUsuario(usuarioDomainTmp.getNombreUsuario()).setPassword(usuarioDomainTmp.getPassword());
	}
	
	@Override
    public final List<UsuarioDTO> ensamblarListaDTO(List<UsuarioDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<UsuarioDomain>());
        var resultados = new ArrayList<UsuarioDTO>();

        for (UsuarioDomain usuarioDomain : listaDominiosTmp) {
            var usuarioDtoTmp = ensamblarDTO(usuarioDomain);
            resultados.add(usuarioDtoTmp);
        }
        return resultados;
    }


}
