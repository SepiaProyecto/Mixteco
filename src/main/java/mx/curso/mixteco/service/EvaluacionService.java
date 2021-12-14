package mx.curso.mixteco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.curso.mixteco.model.Evaluacion;
import mx.curso.mixteco.repository.IEvaluacionService;

@Service
public class EvaluacionService implements IEvaluacionService {

	@Override
	public List<Evaluacion> listEvaluacion() {
		List<Evaluacion>  listEvaluacion=new ArrayList<>();
		Evaluacion evaluacion1= new Evaluacion();
		evaluacion1.setId(1);
		evaluacion1.setPregunta1("como 1?ok");
		evaluacion1.setPregunta2("como 2?");
		evaluacion1.setPregunta3("como 3?");
		evaluacion1.setValor1("OK");
		evaluacion1.setValor2("NO");
		evaluacion1.setValor3("NO");
		evaluacion1.setNombre("xd");
		
		Evaluacion evaluacion2= new Evaluacion();
		evaluacion2.setId(2);
		evaluacion2.setPregunta1("como 12ok?");
		evaluacion2.setPregunta2("como 22?");
		evaluacion2.setPregunta3("como 32?");
		evaluacion2.setValor1("OK");
		evaluacion2.setValor2("NO");
		evaluacion2.setValor3("NO");
		evaluacion2.setNombre("xd2");
		
		
		Evaluacion evaluacion3= new Evaluacion();
		evaluacion3.setId(1);
		evaluacion3.setPregunta1("como 13?");
		evaluacion3.setPregunta2("como 23?");
		evaluacion3.setPregunta3("como 33ok?");
		evaluacion3.setValor1("NO");
		evaluacion3.setValor2("NO");
		evaluacion3.setValor3("OK");
		evaluacion3.setNombre("xd3");
		
		
		listEvaluacion.add(evaluacion1);
		listEvaluacion.add(evaluacion2);
		listEvaluacion.add(evaluacion3);
		return listEvaluacion;
	}

}
