package co.edu.uco.skilltrade.business.assembler.entity.concrete;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.skilltrade.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.CursoDomain;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.entity.CursoEntity;

public class CursoEntityDomainAssembler implements EntityDomainAssembler<CursoDomain, CursoEntity> {
	
	private static final EntityDomainAssembler<CursoDomain, CursoEntity> instancia = new CursoEntityDomainAssembler();
	
	private CursoEntityDomainAssembler() {
        super();
    }
	
	public static final EntityDomainAssembler<CursoDomain, CursoEntity> obtenerInstancia(){
        return instancia;
    }

	@Override
    public final CursoDomain ensamblarDominio(final CursoEntity entidad) {
        var cursoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad,CursoEntity.build());
        return CursoDomain.crear(cursoEntityTmp.getId(), cursoEntityTmp.getTitulo(), cursoEntityTmp.getDescripcion(), CategoriaEntityDomainAssembler.obtenerInstancia().ensamblarDominio(cursoEntityTmp.getCategoria()),
        		UsuarioEntityDomainAssembler.obtenerInstancia().ensamblarDominio(cursoEntityTmp.getUsuario()), EstadoCursoEntityDomainAssembler.obtenerInstancia().ensamblarDominio(cursoEntityTmp.getEstado()));
    }

    @Override
    public final CursoEntity ensamblarEntidad(final CursoDomain dominio) {
        var cursoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CursoDomain.crear());
        return CursoEntity.build(cursoDomainTmp.getId(), cursoDomainTmp.getTitulo(), cursoDomainTmp.getDescripcion(), CategoriaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(cursoDomainTmp.getCategoria()),
        		UsuarioEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(cursoDomainTmp.getUsuario()), EstadoCursoEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(cursoDomainTmp.getEstado()));
    }

    @Override
    public final List<CursoDomain> ensamblarListaDominios(List<CursoEntity> listaEntidades) {
        var listaEntidaesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<CursoEntity>());
        var resultados = new ArrayList<CursoDomain>();

        for (CursoEntity cursoEntity : listaEntidaesTmp) {
            var cursoDomainTmp = ensamblarDominio(cursoEntity);
            resultados.add(cursoDomainTmp);
        }
        return resultados;
    }
	
}
