package co.edu.uco.skilltrade.business.assembler.dto.concrete;

import java.util.ArrayList;


import java.util.List;

import co.edu.uco.skilltrade.business.assembler.dto.DTOEntityAssembler;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.dto.UsuarioDTO;
import co.edu.uco.skilltrade.entity.UsuarioEntity;

public class UsuarioDTOEntityAssembler implements DTOEntityAssembler<UsuarioEntity, UsuarioDTO> {

	private static final DTOEntityAssembler<UsuarioEntity, UsuarioDTO> instancia =
			new UsuarioDTOEntityAssembler();
	
	private UsuarioDTOEntityAssembler() {
		super ();
	}
	
	public static final DTOEntityAssembler<UsuarioEntity, UsuarioDTO> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final UsuarioEntity ensamblarEntity(final UsuarioDTO dto) {
		var usuarioDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, UsuarioDTO.build());
		return UsuarioEntity.build(usuarioDtoTmp.getCorreo(), usuarioDtoTmp.getNombreUsuario(), usuarioDtoTmp.getPassword());
	}

	@Override
	public final UsuarioDTO ensamblarDTO(final UsuarioEntity entidad) {
		var usuarioEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, UsuarioEntity.build());
		return UsuarioDTO.build().setCorreo(usuarioEntityTmp.getCorreo()).setNombreUsuario(usuarioEntityTmp.getNombreUsuario()).setPassword(usuarioEntityTmp.getPassword());
	}
	
	@Override
    public final List<UsuarioEntity> ensamblarListaDTO(List<UsuarioDTO> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<UsuarioDTO>());
        var resultados = new ArrayList<UsuarioEntity>();

        for (UsuarioDTO usuarioDTO : listaDominiosTmp) {
            var usuarioEntityTmp = ensamblarEntity(usuarioDTO);
            resultados.add(usuarioEntityTmp);
        }
        return resultados;
    }


}
