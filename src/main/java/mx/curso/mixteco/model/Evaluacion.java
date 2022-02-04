package mx.curso.mixteco.model;

import java.util.List;

import lombok.Data;

@Data
public class Evaluacion {
	private int id;
	private String valor1;
	private String valor2;
	private String valor3;
	private String nombre;
	private String pregunta1;
	private String pregunta2;
	private String pregunta3;
	private String audiocorto;
	 private List<Imagen> imagen;
	    private List<Audio> audio;
	    private String urlcorto;
	  
	    private List<String> respuestas;
	    private String activad;
	  
	    private String nivel;
	
}
