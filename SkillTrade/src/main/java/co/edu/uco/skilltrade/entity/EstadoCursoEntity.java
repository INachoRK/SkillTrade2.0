package co.edu.uco.skilltrade.entity;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class EstadoCursoEntity {
	
	private UUID id;
	private String nombre;
	
	
	private EstadoCursoEntity(final UUID id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private EstadoCursoEntity(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EstadoCursoEntity build (final UUID id, final String nombre) {
		return new EstadoCursoEntity(id, nombre);
	}
	
	public static final EstadoCursoEntity build() {
		return new EstadoCursoEntity(UUIDHelper.DEFAULT_UUID);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	private EstadoCursoEntity setId(UUID id) {
		this.id = id;
		return this;
	}

	private EstadoCursoEntity setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
