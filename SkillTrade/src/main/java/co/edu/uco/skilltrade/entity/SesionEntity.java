 package co.edu.uco.skilltrade.entity;

import java.util.UUID;

import co.edu.uco.skilltrade.crosscutting.helpers.NumericHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.UUIDHelper;


public final class SesionEntity {
	
	private UUID id;
	private String titulo;
	private String descripcion;
	private byte[] video;
	private CursoEntity curso;
	
	private SesionEntity(final UUID id) {
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setVideo(NumericHelper.BYTE);
		setCurso(CursoEntity.build());
	}
	
	private SesionEntity(UUID id, String titulo, String descripcion, byte[] video, CursoEntity curso) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setVideo(video);
		setCurso(curso);
	}
	
	public static final SesionEntity build (final UUID id, final String titulo, String descripcion, final byte[] video, final CursoEntity curso) {
		return new SesionEntity(id, titulo, descripcion, video, curso);
	}
	
	public static final SesionEntity build() {
		return new SesionEntity(UUIDHelper.DEFAULT_UUID);
	}
	
	public final UUID getId() {
		return id;
	}

	private final SesionEntity setId(UUID id) {
		this.id = id;
		return this;
	}

	public final String getTitulo() {
		return titulo;
	}

	private final SesionEntity setTitulo(String titulo) {
		this.titulo = TextHelper.applyTrim(titulo);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final SesionEntity setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
		return this;
	}

	public final byte[] getVideo() {
		return video;
	}

	private final SesionEntity setVideo(byte[] video) {
		this.video = video;
		return this;
	}

	public CursoEntity getCurso() {
		return curso;
	}

	private SesionEntity setCurso(CursoEntity curso) {
		this.curso = ObjectHelper.getObjectHelper().getDefault(curso, CursoEntity.build());
		return this;
	}

}
