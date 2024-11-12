package co.edu.uco.skilltrade.dto;


import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class CategoriaDTO {
	
	private UUID id;
	private String nombre;
	
	
	private CategoriaDTO(final UUID id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private CategoriaDTO(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final CategoriaDTO build (final UUID id, final String nombre) {
		return new CategoriaDTO(id, nombre);
	}
	
	public static final CategoriaDTO build() {
		return new CategoriaDTO(UUIDHelper.DEFAULT_UUID, TextHelper.EMPTY);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public CategoriaDTO setId(UUID id) {
		this.id = id;
		return this;
	}

	public CategoriaDTO setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}

