package co.edu.uco.skilltrade.api.controller.response.curso;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.skilltrade.api.controller.response.Response;
import co.edu.uco.skilltrade.dto.CursoDTO;

public class CursoResponse extends Response<CursoDTO> {
	
	private List<String> mensajes;
    private List<CursoDTO> datos;
    

    public static final CursoResponse build(final List<String> mensajes, final List<CursoDTO> datos) {

    	CursoResponse instance = new CursoResponse();
        instance.setMensajes(mensajes);
        instance.setDatos(datos);
        

        return instance;
    }

    public static final CursoResponse build(final List<CursoDTO> datos) {

    	CursoResponse instance = new CursoResponse();
        instance.setMensajes(new ArrayList<>());
        instance.setDatos(new ArrayList<>());
        
        

        return instance;
    }

    public static final CursoResponse build() {

    	CursoResponse instance = new CursoResponse();
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

    
    public List<CursoDTO> getDatos() {
        return datos;
    }

    public void setDatos(List<CursoDTO> datos) {
        this.datos = datos;
    }

}