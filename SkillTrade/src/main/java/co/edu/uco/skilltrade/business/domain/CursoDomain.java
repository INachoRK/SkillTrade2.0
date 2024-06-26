package co.edu.uco.skilltrade.business.domain;

import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public class CursoDomain {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String categoria;
	
	
	private CursoDomain(int id, String titulo, String descripcion, String categoria) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		
		
	}
	
	private CursoDomain() {
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setCategoria(TextHelper.EMPTY);
		
	}
	
	public static final CursoDomain crear (final int id, final String titulo, String descripcion, final String categoria) {
		return new CursoDomain(id, titulo, descripcion, categoria);
	}
	
	public static final CursoDomain crear() {
		return new CursoDomain();
	}
	
	private final CursoDomain setId(final int id) {
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
	
	private final CursoDomain setCategoria(String categoria) {
		this.categoria = TextHelper.applyTrim(categoria);
		return this;
	}
	
	public final int getId() {
		return id;
	}
	
	public final String getTitulo() {
		return titulo;
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
	
	public final String getCategoria() {
		return categoria;
	}

}
