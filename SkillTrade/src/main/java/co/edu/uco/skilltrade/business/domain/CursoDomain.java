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
	
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	private void setId(int id) {
		this.id = id;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
