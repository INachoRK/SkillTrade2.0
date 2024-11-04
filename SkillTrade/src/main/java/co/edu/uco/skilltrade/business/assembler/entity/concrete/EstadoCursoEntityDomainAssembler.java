package co.edu.uco.skilltrade.business.assembler.entity.concrete;

import java.util.ArrayList;


import java.util.List;

import co.edu.uco.skilltrade.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.EstadoCursoDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.entity.EstadoCursoEntity;

public class EstadoCursoEntityDomainAssembler implements EntityDomainAssembler<EstadoCursoDomain, EstadoCursoEntity> {
	
	private static final EntityDomainAssembler<EstadoCursoDomain, EstadoCursoEntity> instancia = new EstadoCursoEntityDomainAssembler();
	
	private EstadoCursoEntityDomainAssembler() {
        super();
    }
	
	public static final EntityDomainAssembler<EstadoCursoDomain, EstadoCursoEntity> obtenerInstancia(){
        return instancia;
    }

	@Override
    public final EstadoCursoDomain ensamblarDominio(final EstadoCursoEntity entidad) {
        var estadoCursoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad,EstadoCursoEntity.build());
        return EstadoCursoDomain.build(estadoCursoEntityTmp.getId(), estadoCursoEntityTmp.getNombre());
    }

    @Override
    public final EstadoCursoEntity ensamblarEntidad(final EstadoCursoDomain dominio) {
        var estadoCursoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, EstadoCursoDomain.build());
        return EstadoCursoEntity.build(estadoCursoDomainTmp.getId(), estadoCursoDomainTmp.getNombre());
    }

    @Override
    public final List<EstadoCursoDomain> ensamblarListaDominios(List<EstadoCursoEntity> listaEntidades) {
        var listaEntidaesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<EstadoCursoEntity>());
        var resultados = new ArrayList<EstadoCursoDomain>();

        for (EstadoCursoEntity estadoCursoEntity : listaEntidaesTmp) {
            var estadoCursoDomainTmp = ensamblarDominio(estadoCursoEntity);
            resultados.add(estadoCursoDomainTmp);
        }
        return resultados;
    }
	
}
