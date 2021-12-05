package mx.curso.mixteco.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Respuesta {

	   public int id;
	    public String ok;
	    public String nook;
	    public String nook1;
}
