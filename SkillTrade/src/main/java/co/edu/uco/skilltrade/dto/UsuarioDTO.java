package co.edu.uco.skilltrade.dto;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class UsuarioDTO {
	
	private UUID id;
	private String correo;
	private String nombreUsuario;
	private String password;
	
	private UsuarioDTO() {
		setId(UUIDHelper.DEFAULT_UUID);
		setCorreo(TextHelper.EMPTY);
		setNombreUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	
	private UsuarioDTO(UUID id, String correo, String nombreUsuario, String password) {
		setId(id);
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
		
	}
	
	public static final UsuarioDTO build (final UUID id, final String correo, final String nombreUsuario, final String password) {
		return new UsuarioDTO(id, correo, nombreUsuario, password);
	}
	
	public static final UsuarioDTO build() {
		return new UsuarioDTO();
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

	public UsuarioDTO setId(UUID id) {
		this.id = UUIDHelper.getDefault(id);
		return this;
	}
	
	public UsuarioDTO setCorreo(String correo) {
		this.correo = TextHelper.applyTrim(correo);
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
