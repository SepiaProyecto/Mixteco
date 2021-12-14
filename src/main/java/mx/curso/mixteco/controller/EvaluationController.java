package mx.curso.mixteco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.model.Evaluacion;
import mx.curso.mixteco.repository.IEvaluacionService;

@RestController
@Slf4j
public class EvaluationController {

	
	@Autowired
	private IEvaluacionService iEvaluacionService;

	
	@GetMapping("/evaluation")
	public List<Evaluacion>  infoExamen() {
	Usuario usuario= new Usuario();
	log.info("---------JSON Evaluacion---------");
	return	  iEvaluacionService.listEvaluacion();
	
	}
	
}
