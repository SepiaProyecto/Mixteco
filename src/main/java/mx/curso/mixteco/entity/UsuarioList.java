package mx.curso.mixteco.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UsuarioList {
	private List<Usuario> employees;

    public UsuarioList() {
        employees = new ArrayList<>();
    }
}
