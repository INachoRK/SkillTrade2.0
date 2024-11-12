package co.edu.uco.skilltrade.data.dao.general;

import java.util.List;

public interface ConsultarPorNombreDAO<E> {
	
	List<E> consultarPorNombre(E entidad);
	
}
