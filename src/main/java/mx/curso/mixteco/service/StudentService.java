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

@Slf4j
@Service
public class StudentService {
	
	private  RestTemplate restTemplate = new RestTemplate();
   
    public List<Usuario> getUsuario(Usuario user1){
    //	String host = "https://contenidostrapi.herokuapp.com";
		String host = "http://localhost:1337";
    	
    	String fooResourceUrl = host+"/usuariosepias?usuario="+user1.getUsuario();
    	
		log.info("Consulta de lista de usuario");
		ResponseEntity<List<Usuario>> response= restTemplate.exchange(
				fooResourceUrl,
				HttpMethod.GET,
				null,
				 new ParameterizedTypeReference<List<Usuario>>(){});

		Usuario  userreport=new Usuario(); 
		
		userreport.setApellidomaterno(response.getBody().get(0).getApellidomaterno());
		userreport.setApellidopaterno(response.getBody().get(0).getApellidopaterno());
		userreport.setCalificacion(user1.getCalificacion());
		userreport.setCorreo(response.getBody().get(0).getCorreo());
		userreport.setEdad(response.getBody().get(0).getEdad());
		userreport.setId(response.getBody().get(0).getId());
		userreport.setNombre(response.getBody().get(0).getNombre());
		userreport.setSexo(response.getBody().get(0).getSexo());
		userreport.setUsuario(response.getBody().get(0).getUsuario());
		List<Usuario> employees  =new ArrayList<>();
		employees.add(userreport);		
	
		log.info("usuario recuperado desde el  front "+user1);

        return employees;
    }
}
