package co.edu.uco.skilltrade.business.domain;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class EstadoCursoDomain {
	
	private UUID id;
	private String nombre;
	
	
	private EstadoCursoDomain(final UUID id) {
		setNombre(TextHelper.EMPTY);
	}
	
	
	private EstadoCursoDomain(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EstadoCursoDomain build (final UUID id, final String nombre) {
		return new EstadoCursoDomain(id, nombre);
	}
	
	public static final EstadoCursoDomain build() {
		return new EstadoCursoDomain(UUIDHelper.DEFAULT_UUID);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public EstadoCursoDomain setId(UUID id) {
		this.id = id;
		return this;
	}

	public EstadoCursoDomain setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
