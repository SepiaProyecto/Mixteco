package mx.curso.mixteco.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.model.Evaluacion;
import mx.curso.mixteco.repository.INivel3Service;

@Slf4j
@Service
public class Preguntanivel3Service implements INivel3Service {
	
//	private final String host = "https://contenidostrapi.herokuapp.com";
	private final String host="http://localhost:1337";
	private  RestTemplate restTemplate = new RestTemplate();

	@Override
	public Evaluacion listEvaluacion(int id) {
		
		
		String fooResourceUrl = host+"/dialognivel-3-s";
		log.info("Consulta peguntas nivel3");
		ResponseEntity<List<Evaluacion>> response= restTemplate.exchange(
				fooResourceUrl,
				HttpMethod.GET,
				null,
				 new ParameterizedTypeReference<List<Evaluacion>>(){});

		
		return response.getBody().get(id);
	}

}
