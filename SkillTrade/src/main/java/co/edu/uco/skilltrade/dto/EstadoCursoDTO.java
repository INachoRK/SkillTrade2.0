package co.edu.uco.skilltrade.dto;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class EstadoCursoDTO {
	
	private UUID id;
	private String nombre;
	
	
	private EstadoCursoDTO(final UUID id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private EstadoCursoDTO(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EstadoCursoDTO build (final UUID id, final String nombre) {
		return new EstadoCursoDTO(id, nombre);
	}
	
	public static final EstadoCursoDTO build() {
		return new EstadoCursoDTO(UUIDHelper.DEFAULT_UUID);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public EstadoCursoDTO setId(UUID id) {
		this.id = id;
		return this;
	}

	public EstadoCursoDTO setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
