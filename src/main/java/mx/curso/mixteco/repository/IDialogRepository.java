package mx.curso.mixteco.repository;

import java.util.List;

import mx.curso.mixteco.model.Dialogo;

public interface IDialogRepository {
	public List<Dialogo> listdialog(String numEjempl,int order);
}
