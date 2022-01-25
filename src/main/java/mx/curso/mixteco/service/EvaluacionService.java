package mx.curso.mixteco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.model.Evaluacion;
import mx.curso.mixteco.repository.IEvaluacionService;

@Slf4j
@Service
public class EvaluacionService implements IEvaluacionService {
	
//	private final String host = "https://contenidostrapi.herokuapp.com";
	private final String host="http://localhost:1337";
	private  RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Evaluacion> listEvaluacion() {
		
	
		
		
		String fooResourceUrl = host+"/examen";
		log.info("Consulta de lista de usuario");
		ResponseEntity<List<Evaluacion>> response= restTemplate.exchange(
				fooResourceUrl,
				HttpMethod.GET,
				null,
				 new ParameterizedTypeReference<List<Evaluacion>>(){});

		List<Evaluacion> employees  =response.getBody();
		

		
		return employees;
	}

}
