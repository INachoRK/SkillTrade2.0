package co.edu.uco.skilltrade.data.dao;

import co.edu.uco.skilltrade.data.dao.general.ActualizarDAO;

import co.edu.uco.skilltrade.data.dao.general.ConsultarDAO;
import co.edu.uco.skilltrade.data.dao.general.CrearDAO;
import co.edu.uco.skilltrade.data.dao.general.EliminarDAO;
import co.edu.uco.skilltrade.entity.EstadoCursoEntity;

public interface EstadoCursoDAO
		extends CrearDAO<EstadoCursoEntity>, ActualizarDAO<EstadoCursoEntity>, EliminarDAO, ConsultarDAO<EstadoCursoEntity> {

}