package mx.curso.mixteco.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Imagen {
		private int id;
	    private String name;
	    private String alternativeText;
	    private String caption;
	    private int width;
	    private int height;
	    private String hash;
	    private String ext;
	    private String mime;
	    private double size;
	    private String url;
	    private String previewUrl;
	    private String provider;
	    private String provider_metadata;
	    private Date created_at;
	    private Date updated_at;
		
	    
	    
}
