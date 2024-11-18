package co.edu.uco.skilltrade.dto;


import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class CursoDTO {
	
	private UUID id;
	private String titulo;
	private String descripcion;
	private CategoriaDTO categoria;
	private UsuarioDTO usuario;
	private EstadoCursoDTO estado;
	
	
	public CursoDTO() {
		setId(UUIDHelper.DEFAULT_UUID);
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setCategoria(CategoriaDTO.build());
		setUsuario(UsuarioDTO.build());
		setEstado(EstadoCursoDTO.build());
		
	}
	
	public CursoDTO(UUID id, String titulo, String descripcion, CategoriaDTO categoria, UsuarioDTO usuario, EstadoCursoDTO estado) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setUsuario(usuario);
		setEstado(estado);
		
	}
	
	public static final CursoDTO build() {
		return new CursoDTO();
	}
	
	public final CursoDTO setId(final UUID id) {
		this.id = UUIDHelper.generateNewUUID();
		return this;
	}
	
	public final CursoDTO setTitulo(String titulo) {
		this.titulo = TextHelper.applyTrim(titulo);
		return this;
	}
	
	public final CursoDTO setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
		return this;
	}
	
	public final CursoDTO setCategoria(CategoriaDTO categoria) {
		this.categoria = ObjectHelper.getObjectHelper().getDefault(categoria, CategoriaDTO.build());
		return this;
	}
	
	public final CursoDTO setUsuario(UsuarioDTO usuario) {
		this.usuario = ObjectHelper.getObjectHelper().getDefault(usuario, UsuarioDTO.build());
		return this;
	}

	public final CursoDTO setEstado(EstadoCursoDTO estado) {
		this.estado = ObjectHelper.getObjectHelper().getDefault(estado, EstadoCursoDTO.build());
		return this;
	}
	
	public final UUID getId() {
		return id;
	}
	
	public final String getTitulo() {
		return titulo;
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
	
	public final CategoriaDTO getCategoria() {
		return categoria;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public EstadoCursoDTO getEstado() {
		return estado;
	}

	
	
	

}

