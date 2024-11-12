package co.edu.uco.skilltrade.data.dao;

import co.edu.uco.skilltrade.data.dao.general.ActualizarDAO;

import co.edu.uco.skilltrade.data.dao.general.ConsultarDAO;
import co.edu.uco.skilltrade.data.dao.general.ConsultarPorNombreDAO;
import co.edu.uco.skilltrade.data.dao.general.CrearDAO;
import co.edu.uco.skilltrade.data.dao.general.EliminarDAO;
import co.edu.uco.skilltrade.entity.CategoriaEntity;

public interface CategoriaDAO
		extends CrearDAO<CategoriaEntity>, ActualizarDAO<CategoriaEntity>, EliminarDAO, ConsultarDAO<CategoriaEntity>, ConsultarPorNombreDAO<CategoriaEntity>{

}