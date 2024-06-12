package co.edu.uco.skilltrade.dto;


import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class CategoriaDTO {
	
	private int id;
	private String nombre;
	
	
	private CategoriaDTO(final int id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private CategoriaDTO(int id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final CategoriaDTO build (final int id, final String nombre) {
		return new CategoriaDTO(id, nombre);
	}
	
	public static final CategoriaDTO build() {
		return new CategoriaDTO(NumericHelper.ZERO);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public CategoriaDTO setId(int id) {
		this.id = id;
		return this;
	}

	public CategoriaDTO setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}

