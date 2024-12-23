	package co.edu.uco.skilltrade.dto;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;

public final class SesionDTO {
	
	private UUID id;
	private String titulo;
	private String descripcion;
	private byte[] video;
	private CursoDTO curso;	
	
	private SesionDTO(final UUID id) {
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setVideo(NumericHelper.BYTE);
		setCurso(CursoDTO.build());
	}
	
	private SesionDTO(UUID id, String titulo, String descripcion, byte[] video, CursoDTO curso) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setVideo(video);
		setCurso(CursoDTO.build());
	}
	
	public static final SesionDTO build (final UUID id, final String titulo, String descripcion, final byte[] video, final CursoDTO curso) {
		return new SesionDTO(id, titulo, descripcion, video, curso);
	}
	
	public static final SesionDTO build() {
		return new SesionDTO(UUIDHelper.DEFAULT_UUID);
	}
	
	public final UUID getId() {
		return id;
	}
	public final SesionDTO setId(UUID id) {
		this.id = id;
		return this;
	}
	public final String getTitulo() {
		return titulo;
	}
	public final SesionDTO setTitulo(String titulo) {
		this.titulo = TextHelper.applyTrim(titulo);
		return this;
	}
	public final String getDescripcion() {
		return descripcion;
	}
	public final SesionDTO setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
		return this;
	}
	public final byte[] getVideo() {
		return video;
	}
	public final SesionDTO setVideo(byte[] video) {
		this.video = video;
		return this;
	}

	public CursoDTO getCurso() {
		return curso;
	}

	public SesionDTO setCurso(CursoDTO curso) {
		this.curso = ObjectHelper.getObjectHelper().getDefault(curso, CursoDTO.build());
		return this;
	}

}
