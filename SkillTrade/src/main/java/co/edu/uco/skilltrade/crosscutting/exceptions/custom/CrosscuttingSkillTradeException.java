package co.edu.uco.skilltrade.crosscutting.exceptions.custom;

import co.edu.uco.skilltrade.crosscutting.exceptions.SkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingSkillTradeException extends SkillTradeException {

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.CROSSCUTTING;

	public CrosscuttingSkillTradeException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public CrosscuttingSkillTradeException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public CrosscuttingSkillTradeException(final String mensajeTecnico, final String mensajeUsuario,
			final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
