package co.edu.uco.skilltrade.entity;

import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class CursoEntity {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String categoria;
	
	
	private CursoEntity(final int id) {
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setCategoria(TextHelper.EMPTY);
		
	}
	
	
	private CursoEntity(int id, String titulo, String descripcion, String categoria) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		
	}
	
	public static final CursoEntity build (final int id, final String titulo, String descripcion, final String categoria) {
		return new CursoEntity(id, titulo, descripcion, categoria);
	}
	
	public static final CursoEntity build() {
		return new CursoEntity(NumericHelper.ZERO);
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
	
	private CursoEntity setId(int id) {
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

	private CursoEntity setCategoria(String categoria) {
		this.categoria =  TextHelper.applyTrim(categoria);
		return this;
	}

}
