package co.edu.uco.skilltrade.business.assembler.dto;

import java.util.List;

public interface DTOEntityAssembler<E, T> {

	E ensamblarEntity (T dto);
	
	T ensamblarDTO (E entity);
	
	List<E> ensamblarListaDTO(List<T> listaDominios);
}
