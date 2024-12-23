package co.edu.uco.skilltrade.data.dao;

import co.edu.uco.skilltrade.data.dao.general.ActualizarDAO;


import co.edu.uco.skilltrade.data.dao.general.ConsultarDAO;
import co.edu.uco.skilltrade.data.dao.general.CrearDAO;
import co.edu.uco.skilltrade.data.dao.general.EliminarDAO;
import co.edu.uco.skilltrade.entity.UsuarioEntity;

public interface UsuarioDAO
		extends CrearDAO<UsuarioEntity>, ActualizarDAO<UsuarioEntity>, EliminarDAO, ConsultarDAO<UsuarioEntity> {

}