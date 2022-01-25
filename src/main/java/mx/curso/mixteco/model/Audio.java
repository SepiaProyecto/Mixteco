package mx.curso.mixteco.model;

import java.util.Date;

import lombok.Data;

@Data
public class Audio {
	 private int id;
	    private String name;
	    private String alternativeText;
	    private String caption;
	    private Object width;
	    private Object height;
	    private Object formats;
	    private String hash;
	    private String ext;
	    private String mime;
	    private double size;
	    private String url;
	    private Object previewUrl;
	    private String provider;
	    private String provider_metadata;
	    private Date created_at;
	    private Date updated_at;
}
