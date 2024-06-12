package co.edu.uco.skilltrade.api.controller.response.usuario;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.skilltrade.api.controller.response.Response;
import co.edu.uco.skilltrade.dto.UsuarioDTO;

public class UsuarioResponse extends Response<UsuarioDTO> {
	
	private List<String> mensajes;
    private List<UsuarioDTO> datos;
    private boolean accesoAutorizado;

    public static final UsuarioResponse build(final List<String> mensajes, final List<UsuarioDTO> datos, final boolean accesoAutorizado) {

    	UsuarioResponse instance = new UsuarioResponse();
        instance.setMensajes(mensajes);
        instance.setDatos(datos);
        instance.setAccesoAutorizado(accesoAutorizado);

        return instance;
    }

    public static final UsuarioResponse build(final List<UsuarioDTO> datos) {

    	UsuarioResponse instance = new UsuarioResponse();
        instance.setMensajes(new ArrayList<>());
        instance.setDatos(new ArrayList<>());
        instance.setAccesoAutorizado(false);
        

        return instance;
    }

    public static final UsuarioResponse build() {

    	UsuarioResponse instance = new UsuarioResponse();
        instance.setMensajes(new ArrayList<>());
        instance.setDatos(new ArrayList<>());

        return instance;
    }
    
    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }

    
    public List<UsuarioDTO> getDatos() {
        return datos;
    }

    public void setDatos(List<UsuarioDTO> datos) {
        this.datos = datos;
    }

	public boolean isAccesoAutorizado() {
		return accesoAutorizado;
	}

	public void setAccesoAutorizado(boolean accesoAutorizado) {
		this.accesoAutorizado = accesoAutorizado;
	}
}