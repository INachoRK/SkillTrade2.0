package co.edu.uco.skilltrade.business.domain;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public class CursoDomain {
	
	private UUID id;
	private String titulo;
	private String descripcion;
	private CategoriaDomain categoria;
	private UsuarioDomain usuario;
	private EstadoCursoDomain estado;
	
	
	private CursoDomain(UUID id, String titulo, String descripcion, CategoriaDomain categoria, UsuarioDomain usuario, EstadoCursoDomain estado) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setUsuario(usuario);
		setEstado(estado);
	}
	
	private CursoDomain() {
		setId(UUIDHelper.DEFAULT_UUID);
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setCategoria(CategoriaDomain.build());
		setUsuario(UsuarioDomain.build());
		setEstado(EstadoCursoDomain.build());
		
	}
	
	public static final CursoDomain crear (final UUID id, final String titulo, final String descripcion, final CategoriaDomain categoria, UsuarioDomain usuario, EstadoCursoDomain estado) {
		return new CursoDomain(id, titulo, descripcion, categoria, usuario, estado); 
	}
	
	public static final CursoDomain crear() {
		return new CursoDomain();
	}
	
	private final CursoDomain setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	private final CursoDomain setTitulo(String titulo) {
		this.titulo = TextHelper.applyTrim(titulo);
		return this;
	}
	
	private final CursoDomain setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
		return this;
	}
	
	private final CursoDomain setCategoria(CategoriaDomain categoria) {
		this.categoria = ObjectHelper.getObjectHelper().getDefault(categoria, CategoriaDomain.build());
		return this;
	}
	
	public final CursoDomain setUsuario(UsuarioDomain usuario) {
		this.usuario = ObjectHelper.getObjectHelper().getDefault(usuario, UsuarioDomain.build());
		return this;
	}

	public final CursoDomain setEstado(EstadoCursoDomain estado) {
		this.estado = ObjectHelper.getObjectHelper().getDefault(estado, EstadoCursoDomain.build());
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
	
	public final CategoriaDomain getCategoria() {
		return categoria;
	}

	public UsuarioDomain getUsuario() {
		return usuario;
	}

	public EstadoCursoDomain getEstado() {
		return estado;
	}

	

}
