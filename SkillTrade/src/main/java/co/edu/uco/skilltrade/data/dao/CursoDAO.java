package co.edu.uco.skilltrade.data.dao;

import co.edu.uco.skilltrade.data.dao.general.ActualizarDAO;
import co.edu.uco.skilltrade.data.dao.general.ConsultarDAO;
import co.edu.uco.skilltrade.data.dao.general.CrearDAO;
import co.edu.uco.skilltrade.data.dao.general.EliminarDAO;
import co.edu.uco.skilltrade.entity.CursoEntity;

public interface CursoDAO
		extends CrearDAO<CursoEntity>, ActualizarDAO<CursoEntity>, EliminarDAO, ConsultarDAO<CursoEntity> {

}