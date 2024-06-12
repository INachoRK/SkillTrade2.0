package co.edu.uco.skilltrade.entity;

import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class CategoriaEntity {
	
	private int id;
	private String nombre;
	
	
	private CategoriaEntity(final int id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private CategoriaEntity(int id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final CategoriaEntity build (final int id, final String nombre) {
		return new CategoriaEntity(id, nombre);
	}
	
	public static final CategoriaEntity build() {
		return new CategoriaEntity(NumericHelper.ZERO);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	private CategoriaEntity setId(int id) {
		this.id = id;
		return this;
	}

	private CategoriaEntity setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
