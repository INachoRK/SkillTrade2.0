package co.edu.uco.skilltrade.entity;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class UsuarioEntity {
	
	private UUID id;
	private String correo;
	private String nombreUsuario;
	private String password;
	
	private UsuarioEntity() {
		setId(UUIDHelper.DEFAULT_UUID);
		setCorreo(TextHelper.EMPTY);
		setNombreUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	private UsuarioEntity(UUID id, String correo, String nombreUsuario, String password) {
		setId(id);
		setCorreo(correo);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
		
	}
	
	public static final UsuarioEntity build (final UUID id, final String correo, final String nombreUsuario, final String password) {
		return new UsuarioEntity(id, correo, nombreUsuario, password);
	}
	
	public static final UsuarioEntity build() {
		return new UsuarioEntity();
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
	
	public UsuarioEntity setId(UUID id) {
		this.id = UUIDHelper.getDefault(id);
		return this;
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
