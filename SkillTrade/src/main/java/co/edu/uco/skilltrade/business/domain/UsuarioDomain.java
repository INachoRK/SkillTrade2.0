package co.edu.uco.skilltrade.business.domain;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class UsuarioDomain {
	
	private String correo;
	private String nombreUsuario;
	private String password;
	
	private UsuarioDomain() {
		setCorreo(TextHelper.EMPTY);
		setNombreUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	
	private UsuarioDomain(String correo, String nombreUsuario, String password) {
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
		
	}
	
	private UsuarioDomain(String correo, String nombreUsuario) {
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
	}
	
	public static final UsuarioDomain crear (final String correo, final String nombreUsuario, final String password) {
		return new UsuarioDomain(correo, nombreUsuario, password);
	}
	
	public static final UsuarioDomain build (final String correo, final String nombreUsuario) {
		return new UsuarioDomain(correo, nombreUsuario);
	}
	
	public static final UsuarioDomain build() {
		return new UsuarioDomain();
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

	private UsuarioDomain setCorreo(String correo) {
		this.correo = correo;
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
