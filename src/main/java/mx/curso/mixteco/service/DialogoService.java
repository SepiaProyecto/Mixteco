package mx.curso.mixteco.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.model.Dialogo;
import mx.curso.mixteco.repository.IDialogRepository;

@Slf4j
@Service
public class DialogoService implements IDialogRepository{
	
	private  RestTemplate restTemplate=new RestTemplate(); 
	/**
	 * 
	 */
	@Override
	public List<Dialogo> listdialog(String numEjempl,int order) {
		String host = "https://contenidostrapi.herokuapp.com";
		//String host = "http://localhost:1337";
		log.info("Consulta listdialog "+numEjempl);
		ResponseEntity<List<Dialogo>> response= restTemplate.exchange(
				host+"/dialogos?numdialogo="+numEjempl+"&id="+order,
				HttpMethod.GET,
				null,
				 new ParameterizedTypeReference<List<Dialogo>>(){});
	//	response.getBody().get(0).getAudio().get(0).getUrl();
		return response.getBody();
	}
}
