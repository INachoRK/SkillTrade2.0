package co.edu.uco.skilltrade.business.assembler.entity.concrete;

import java.util.ArrayList;


import java.util.List;

import co.edu.uco.skilltrade.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.UsuarioDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.entity.UsuarioEntity;

public class UsuarioEntityDomainAssembler implements EntityDomainAssembler<UsuarioDomain, UsuarioEntity> {
	
	private static final EntityDomainAssembler<UsuarioDomain, UsuarioEntity> instancia = new UsuarioEntityDomainAssembler();
	
	private UsuarioEntityDomainAssembler() {
        super();
    }
	
	public static final EntityDomainAssembler<UsuarioDomain, UsuarioEntity> obtenerInstancia(){
        return instancia;
    }

	@Override
    public final UsuarioDomain ensamblarDominio(final UsuarioEntity entidad) {
        var usuarioEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, UsuarioEntity.build());
        return UsuarioDomain.crear(usuarioEntityTmp.getId(), usuarioEntityTmp.getCorreo(), usuarioEntityTmp.getNombreUsuario(), usuarioEntityTmp.getPassword());
    }

    @Override
    public final UsuarioEntity ensamblarEntidad(final UsuarioDomain dominio) {
        var usuarioDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, UsuarioDomain.build());
        return UsuarioEntity.build(usuarioDomainTmp.getId(), usuarioDomainTmp.getCorreo(), usuarioDomainTmp.getNombreUsuario(), usuarioDomainTmp.getPassword());
    }

    @Override
    public final List<UsuarioDomain> ensamblarListaDominios(List<UsuarioEntity> listaEntidades) {
        var listaEntidaesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<UsuarioEntity>());
        var resultados = new ArrayList<UsuarioDomain>();

        for (UsuarioEntity usuarioEntity : listaEntidaesTmp) {
            var usuarioDomainTmp = ensamblarDominio(usuarioEntity);
            resultados.add(usuarioDomainTmp);
        }
        return resultados;
    }
	
}
