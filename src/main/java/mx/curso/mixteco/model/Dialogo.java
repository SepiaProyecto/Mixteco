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
    private String urlcorto;
    private String audiocorto;
    private String valor1;
    private String valor2;
    private String valor3;
    private List<String> respuestas;
    private String activad;
  
    private String nivel;
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
}
