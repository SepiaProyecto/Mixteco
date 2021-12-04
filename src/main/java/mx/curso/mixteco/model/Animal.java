package mx.curso.mixteco.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Animal {

	   public int id;
	    public String nameespanol;
	    public String namemixteco;
	    public String published_at;
	    public String created_at;
	    public String updated_at;
	    public List<Imagen> imagen;
	    public List<Audio> audio;
	    public String urlcorto;
	    public String audiocorto;
	    public String valorok;
	    public String valornotok;
	    public String valornotok1;
	    public List<String> respuestas;
	    public String activad;
	  
	
	    
}
