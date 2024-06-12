package co.edu.uco.skilltrade.business.domain;

import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class CategoriaDomain {
	
	private int id;
	private String nombre;
	
	
	private CategoriaDomain(final int id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private CategoriaDomain(int id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final CategoriaDomain build (final int id, final String nombre) {
		return new CategoriaDomain(id, nombre);
	}
	
	public static final CategoriaDomain build() {
		return new CategoriaDomain(NumericHelper.ZERO);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	private CategoriaDomain setId(int id) {
		this.id = id;
		return this;
	}

	private CategoriaDomain setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
