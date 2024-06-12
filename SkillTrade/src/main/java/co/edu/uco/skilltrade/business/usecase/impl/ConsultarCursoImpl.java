package co.edu.uco.skilltrade.business.usecase.impl;

import java.util.List;

import co.edu.uco.skilltrade.business.assembler.entity.concrete.CursoEntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.CursoDomain;
import co.edu.uco.skilltrade.business.usecase.ConsultarCurso;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;

public class ConsultarCursoImpl implements ConsultarCurso {

	private final DAOFactory factory;
	
	public ConsultarCursoImpl(final DAOFactory factory){
		this.factory = factory;
	}

	@Override
    public final List<CursoDomain> ejecutar(final CursoDomain curso) {
        var cursoEntity = CursoEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(curso);
        var resultados = factory.getCursoDAO().consultar(cursoEntity);

        return CursoEntityDomainAssembler.obtenerInstancia().ensamblarListaDominios(resultados);
	}
}
