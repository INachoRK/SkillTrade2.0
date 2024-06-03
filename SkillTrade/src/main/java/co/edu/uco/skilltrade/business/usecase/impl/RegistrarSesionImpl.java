package co.edu.uco.skilltrade.business.usecase.impl;

import co.edu.uco.skilltrade.business.assembler.entity.concrete.SesionEntityDomainAssembler;
import co.edu.uco.skilltrade.business.domain.SesionDomain;
import co.edu.uco.skilltrade.business.usecase.RegistrarSesion;
import co.edu.uco.skilltrade.data.dao.factory.DAOFactory;

public class RegistrarSesionImpl implements RegistrarSesion {

	private final DAOFactory factory;
	
	public RegistrarSesionImpl(final DAOFactory factory){
		this.factory = factory;
	}
	
	@Override
	public void ejecutar(SesionDomain sesion) {	
		var sesionEntity = SesionEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(sesion);
        factory.getSesionDAO().crear(sesionEntity);
	}
	
	

}
