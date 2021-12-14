package mx.curso.mixteco.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Numeros {

	   public int id;
	    public String nombre;
	    public String published_at;
	    public String created_at;
	    public String updated_at;
	    public List<Imagen> imagen;
	    public List<Audio> audio;
	    public String urlcorto;
	    public String audiocorto;
	    public String valor1;
	    public String valor2;
	    public String valor3;
	    public List<String> respuestas;
	    public String activad;
	  
	    public String nivel;
	    public String textok;
	    public String pregunta1;
	    public String pregunta2;
	    public String pregunta3;
	    
	    
}
