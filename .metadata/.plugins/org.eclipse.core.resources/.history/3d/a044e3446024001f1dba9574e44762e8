package co.edu.uco.skilltrade.business.usecase.impl;

import co.edu.uco.skilltrade.business.assembler.entity.concrete.CursoEntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.CursoDomain;
import co.edu.uco.skilltrade.business.usecase.RegistrarCurso;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;

public class RegistrarCursoImpl implements RegistrarCurso {

	private final DAOFactory factory;
	
	public RegistrarCursoImpl(final DAOFactory factory){
		this.factory = factory;
	}
	
	@Override
	public void ejecutar(CursoDomain curso) {
		var cursoEntity = CursoEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(curso);
        factory.getCursoDAO().crear(cursoEntity);
	}

}
