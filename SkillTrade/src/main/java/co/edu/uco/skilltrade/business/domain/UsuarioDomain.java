package co.edu.uco.skilltrade.business.domain;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class UsuarioDomain {
	
	private UUID id;
	private String correo;
	private String nombreUsuario;
	private String password;
	
	private UsuarioDomain() {
		setId(UUIDHelper.DEFAULT_UUID);
		setCorreo(TextHelper.EMPTY);
		setNombreUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	
	private UsuarioDomain(UUID id, String correo, String nombreUsuario, String password) {
		setId(id);
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
		
	}
	
	public static final UsuarioDomain crear (final UUID id, final String correo, final String nombreUsuario, final String password) {
		return new UsuarioDomain(id, correo, nombreUsuario, password);
	}
	

	public static final UsuarioDomain build() {
		return new UsuarioDomain();
	}
	
	public UUID getId() {
		return id;
	}

	public String getCorreo() {
		return correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public UsuarioDomain setId(UUID id) {
		this.id = UUIDHelper.getDefault(id);
		return this;
	}

	private UsuarioDomain setCorreo(String correo) {
		this.correo = TextHelper.applyTrim(correo);
		return this;
	}

	private UsuarioDomain setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = TextHelper.applyTrim(nombreUsuario);
		return this;
	}

	private UsuarioDomain setPassword(String password) {
		this.password = TextHelper.applyTrim(password);
		return this;
	}

}
