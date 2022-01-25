package mx.curso.mixteco.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Numeros {

	   private int id;
	    private String nombre;
	    private String published_at;
	    private String created_at;
	    private String updated_at;
	    private List<Imagen> imagen;
	    private List<Audio> audio;
	    private String urlcorto;
	    private String audiocorto;
	    private String valor1;
	    private String valor2;
	    private String valor3;
	    private List<String> respuestas;
	    private String activad;
	  
	    private String nivel;
	
	    private String pregunta1;
	    private String pregunta2;
	    private String pregunta3;
	    
	    
}
