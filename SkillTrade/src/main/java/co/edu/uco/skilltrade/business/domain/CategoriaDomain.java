package co.edu.uco.skilltrade.business.domain;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class CategoriaDomain {
	
	private UUID id;
	private String nombre;
	
	
	private CategoriaDomain(final UUID id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private CategoriaDomain(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final CategoriaDomain build (final UUID id, final String nombre) {
		return new CategoriaDomain(id, nombre);
	}
	
	public static final CategoriaDomain build() {
		return new CategoriaDomain(UUIDHelper.DEFAULT_UUID);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	private CategoriaDomain setId(UUID id) {
		this.id = id;
		return this;
	}

	private CategoriaDomain setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
