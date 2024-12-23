package co.edu.uco.skilltrade.entity;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class CategoriaEntity {
	
	private UUID id;
	private String nombre;
	
	
	private CategoriaEntity(final UUID id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private CategoriaEntity(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final CategoriaEntity build (final UUID id, final String nombre) {
		return new CategoriaEntity(id, nombre);
	}
	
	public static final CategoriaEntity build() {
		return new CategoriaEntity(UUIDHelper.DEFAULT_UUID);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	private CategoriaEntity setId(UUID id) {
		this.id = id;
		return this;
	}

	private CategoriaEntity setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
