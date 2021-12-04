package mx.curso.mixteco.model;

import java.util.Date;

import lombok.Data;

@Data
public class Thumbnail {
	public String name;
    public String hash;
    public String ext;
    public String mime;
    public int width;
    public int height;
    public double size;
    public String path;
    public String url;
}
