package co.edu.uco.skilltrade.api.controller.response.categoria;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.skilltrade.api.controller.response.Response;
import co.edu.uco.skilltrade.dto.CategoriaDTO;

public class CategoriaResponse extends Response<CategoriaDTO> {
	
	private List<String> mensajes;
    private List<CategoriaDTO> datos;

    

    public static final CategoriaResponse build(final List<String> mensajes, final List<CategoriaDTO> datos) {

    	CategoriaResponse instance = new CategoriaResponse();
        instance.setMensajes(mensajes);
        instance.setDatos(datos);

        return instance;
    }

    public static final CategoriaResponse build(final List<CategoriaDTO> datos) {

    	CategoriaResponse instance = new CategoriaResponse();
        instance.setMensajes(new ArrayList<>());
        instance.setDatos(new ArrayList<>());
        

        return instance;
    }

    public static final CategoriaResponse build() {

    	CategoriaResponse instance = new CategoriaResponse();
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

    
    public List<CategoriaDTO> getDatos() {
        return datos;
    }

    public void setDatos(List<CategoriaDTO> datos) {
        this.datos = datos;
    }
    
   
}