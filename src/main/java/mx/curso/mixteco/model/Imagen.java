package mx.curso.mixteco.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Imagen {
		public int id;
	    public String name;
	    public String alternativeText;
	    public String caption;
	    public int width;
	    public int height;
	    public Formats formats;
	    public String hash;
	    public String ext;
	    public String mime;
	    public double size;
	    public String url;
	    public String previewUrl;
	    public String provider;
	    public String provider_metadata;
	    public Date created_at;
	    public Date updated_at;
		@Override
		public String toString() {
			return "Imagen [id=" + id + ", name=" + name + ", alternativeText=" + alternativeText + ", caption="
					+ caption + ", width=" + width + ", height=" + height + ", formats=" + formats + ", hash=" + hash
					+ ", ext=" + ext + ", mime=" + mime + ", size=" + size + ", url=" + url + ", previewUrl="
					+ previewUrl + ", provider=" + provider + ", provider_metadata=" + provider_metadata
					+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
		}
	    
	    
}
