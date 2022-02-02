package mx.curso.mixteco.entity;

import lombok.Data;

@Data
public class Usuario {
	private int id;
	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private String sexo;
	private String edad;
	private String correo;
	private String usuario;
	private String contrasena;
	private String calificacion;

}
