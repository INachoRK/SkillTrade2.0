package co.edu.uco.skilltrade.data.dao.general;

import java.util.List;

public interface ConsultarDAO<E> {
	List<E> consultar(E entidad);
	
	boolean consultarLogin(E entidad);
}
