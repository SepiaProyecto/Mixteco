package mx.curso.mixteco.model;

import java.util.Date;

import lombok.Data;

@Data
public class Audio {
	 public int id;
	    public String name;
	    public String alternativeText;
	    public String caption;
	    public Object width;
	    public Object height;
	    public Object formats;
	    public String hash;
	    public String ext;
	    public String mime;
	    public double size;
	    public String url;
	    public Object previewUrl;
	    public String provider;
	    public String provider_metadata;
	    public Date created_at;
	    public Date updated_at;
}
