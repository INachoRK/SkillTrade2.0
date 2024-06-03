package co.edu.uco.skilltrade.dto;


import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public final class CursoDTO {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String categoria;
	private String subcategoria;
	
	public CursoDTO() {
		setId(NumericHelper.ZERO);
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setCategoria(TextHelper.EMPTY);
		setSubcategoria(TextHelper.EMPTY);
	}
	
	public CursoDTO(int id, String titulo, String descripcion, String categoria, String subcategoria) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setSubcategoria(subcategoria);
	}
	
	public static final CursoDTO build() {
		return new CursoDTO();
	}
	
	public final CursoDTO setId(final int id) {
		this.id = id;
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
	
	public final CursoDTO setCategoria(String categoria) {
		this.categoria = TextHelper.applyTrim(categoria);
		return this;
	}
	
	public CursoDTO setSubcategoria(String subcategoria) {
		this.subcategoria = TextHelper.applyTrim(subcategoria);
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

	public String getSubcategoria() {
		return subcategoria;
	}

	
	
}

