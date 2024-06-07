package co.edu.uco.skilltrade.dto;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class UsuarioDTO {
	
	private String correo;
	private String nombreUsuario;
	private String password;
	
	private UsuarioDTO() {
		setCorreo(TextHelper.EMPTY);
		setNombreUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	
	private UsuarioDTO(String correo, String nombreUsuario, String password) {
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
		
	}
	
	public static final UsuarioDTO build (final String correo, final String nombreUsuario, final String password) {
		return new UsuarioDTO(correo, nombreUsuario, password);
	}
	
	public static final UsuarioDTO build() {
		return new UsuarioDTO();
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

	public UsuarioDTO setCorreo(String correo) {
		this.correo = correo;
		return this;
	}

	public UsuarioDTO setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = TextHelper.applyTrim(nombreUsuario);
		return this;
	}

	public UsuarioDTO setPassword(String password) {
		this.password = TextHelper.applyTrim(password);
		return this;
	}

}
