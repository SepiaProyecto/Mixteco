package mx.curso.mixteco.model;

import java.util.List;

import lombok.Data;

@Data
public class Dialogo {

	private int id;
    private String emisor;
    private String receptor;
    private String numdialogo;
    private String orden;
    private List<Imagen> imagen;
    private List<Audio> audio;
}
