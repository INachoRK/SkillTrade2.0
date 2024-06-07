package co.edu.uco.skilltrade.entity;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class UsuarioEntity {
	
	private String correo;
	private String nombreUsuario;
	private String password;
	
	private UsuarioEntity() {
		setCorreo(TextHelper.EMPTY);
		setNombreUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	
	private UsuarioEntity(String correo, String nombreUsuario, String password) {
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
		
	}
	
	private UsuarioEntity(String correo, String nombreUsuario) {
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
	}
	
	public static final UsuarioEntity build (final String correo, final String nombreUsuario, final String password) {
		return new UsuarioEntity(correo, nombreUsuario, password);
	}
	
	public static final UsuarioEntity build (final String correo, final String nombreUsuario) {
		return new UsuarioEntity(correo, nombreUsuario);
	}
	
	public static final UsuarioEntity build() {
		return new UsuarioEntity();
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

	private UsuarioEntity setCorreo(String correo) {
		this.correo = correo;
		return this;
	}

	private UsuarioEntity setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = TextHelper.applyTrim(nombreUsuario);
		return this;
	}

	private UsuarioEntity setPassword(String password) {
		this.password = TextHelper.applyTrim(password);
		return this;
	}

}
