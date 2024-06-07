package co.edu.uco.skilltrade.business.domain;

import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;
import co.edu.uco.skilltrade.crosscutting.helpers.TextHelper;

public class SesionDomain {
	
	private int id;
	private String titulo;
	private String descripcion;
	private byte[] video;
	private CursoDomain curso;
	
	private SesionDomain() {
		setTitulo(TextHelper.EMPTY);
		setDescripcion(TextHelper.EMPTY);
		setVideo(video);
	}
	
	private SesionDomain(int id, String titulo, String descripcion, byte[] video, CursoDomain curso) {
		setId(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setVideo(video);
		setCurso(CursoDomain.crear());
	}
	
	public static final SesionDomain crear (final int id, final String titulo, String descripcion, byte[] video, CursoDomain curso) {
		return new SesionDomain(id, titulo, descripcion, video, curso);
	}
	
	public static final SesionDomain crear() {
		return new SesionDomain();
	}
	
	public final int getId() {
		return id;
	}

	private final SesionDomain setId(int id) {
		this.id = id;
		return this;
	}

	public final String getTitulo() {
		return titulo;
	}

	private final SesionDomain setTitulo(String titulo) {
		this.titulo = TextHelper.applyTrim(titulo);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final SesionDomain setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
		return this;
	}

	public final byte[] getVideo() {
		return video;
	}

	private final SesionDomain setVideo(byte[] video) {
		this.video = video;
		return this;
	}

	public final CursoDomain getCurso() {
		return curso;
	}

	private final SesionDomain setCurso(CursoDomain curso) {
		this.curso = ObjectHelper.getObjectHelper().getDefault(curso, CursoDomain.crear());
		return this;
	}

}
