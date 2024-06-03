package co.edu.uco.skilltrade.entity;

import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class CursoEntity {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String categoria;
	private String subcategoria;
	
	private CursoEntity(final int id) {
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setCategoria(TextHelper.EMPTY);
		setSubcategoria(TextHelper.EMPTY);
	}
	
	
	private CursoEntity(int id, String titulo, String descripcion, String categoria, String subcategoria) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setSubcategoria(subcategoria);
	}
	
	public static final CursoEntity build (final int id, final String titulo, String descripcion, final String categoria, final String subcategoria) {
		return new CursoEntity(id, titulo, descripcion, categoria, subcategoria);
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
	
	public String getSubcategoria() {
		return subcategoria;
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

	
	public CursoEntity setSubcategoria(String subcategoria) {
		this.subcategoria =  TextHelper.applyTrim(subcategoria);
		return this;
	}

}
