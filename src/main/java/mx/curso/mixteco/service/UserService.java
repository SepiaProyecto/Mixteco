package mx.curso.mixteco.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.repository.IuserRepository;

@Slf4j
@Service
public class UserService implements IuserRepository{

	
	private  RestTemplate restTemplate = new RestTemplate();
	 
	/**
	 * 
	 */
	@Override
	public List<Usuario> list_user() {

		String fooResourceUrl = "https://contenidostrapi.herokuapp.com/usuariosepias";
		log.info("Consulta de lista de usuario");
		ResponseEntity<List<Usuario>> response= restTemplate.exchange(
				fooResourceUrl,
				HttpMethod.GET,
				null,
				 new ParameterizedTypeReference<List<Usuario>>(){});

		List<Usuario> employees  =response.getBody();
		return employees;
	}
}
