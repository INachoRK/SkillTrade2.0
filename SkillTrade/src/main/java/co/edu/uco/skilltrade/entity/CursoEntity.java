package co.edu.uco.skilltrade.entity;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class CursoEntity {
	
	private UUID id;
	private String titulo;
	private String descripcion;
	private CategoriaEntity categoria;
	private UsuarioEntity usuario;
	private EstadoCursoEntity estado;
	
	
	private CursoEntity(final UUID id) {
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setCategoria(CategoriaEntity.build());
		setUsuario(UsuarioEntity.build());
		setEstado(EstadoCursoEntity.build());
		
	}
	
	
	private CursoEntity(UUID id, String titulo, String descripcion, CategoriaEntity categoria, UsuarioEntity usuario, EstadoCursoEntity estado) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setUsuario(usuario);
		setEstado(estado);		
	}
	
	public static final CursoEntity build (final UUID id, final String titulo, final String descripcion, final CategoriaEntity categoria, final UsuarioEntity usuario, final EstadoCursoEntity estado) {
		return new CursoEntity(id, titulo, descripcion, categoria, usuario, estado);
	}
	
	public static final CursoEntity build() {
		return new CursoEntity(UUIDHelper.DEFAULT_UUID);
	}

	public UUID getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	
	public EstadoCursoEntity getEstado() {
		return estado;
	}
	
	private CursoEntity setId(UUID id) {
		this.id = id;
		return this;
	}

	private CursoEntity setTitulo(String titulo) {
		this.titulo = TextHelper.applyTrim(titulo);
		return this;
	}

	private CursoEntity setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
		return this;
	}

	private CursoEntity setCategoria(CategoriaEntity categoria) {
		this.categoria =  ObjectHelper.getObjectHelper().getDefault(categoria, CategoriaEntity.build());
		return this;
	}
	
	private CursoEntity setUsuario(UsuarioEntity usuario) {
		this.usuario = ObjectHelper.getObjectHelper().getDefault(usuario, UsuarioEntity.build());
		return this;
	}

	private CursoEntity setEstado(EstadoCursoEntity estado) {
		this.estado = ObjectHelper.getObjectHelper().getDefault(estado, EstadoCursoEntity.build());
		return this;
	}



}
