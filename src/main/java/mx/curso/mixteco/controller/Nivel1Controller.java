package mx.curso.mixteco.controller;



import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.model.Numeros;
import mx.curso.mixteco.model.Respuesta;



@Controller
@Slf4j
public class Nivel1Controller {
	
	UserController  nn= new UserController();

	@PostMapping("/nivel1")
	public String nivel1(Model model) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);
    log.info("--------nivel1 numero---------");
  Usuario user=  nn.nombreglobal();
  
		return "nivel1/nivel1";
	}
	
	@PostMapping("/numeronivel1")
	public String nivel2Numero(Model model) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);
	log.info("--------nivel1 numero---------2");
	  Usuario user=	nn.nombreglobal();
	
	
RestTemplate restTemplate = new RestTemplate();
    
	String fooResourceUrlcontador= "http://localhost:1337/numeros/count?nivel=nivel1";
	
	ResponseEntity<String> contador
	  = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

	log.info("contador xd "+contador.getBody());
	int numero=Integer.parseInt(contador.getBody());
	
    List<Numeros> numeros_list=new ArrayList<>();
   
    List<String> list_respuestas=new ArrayList<>();
    List<Respuesta> list_uno=new ArrayList<>();
	for (int i=1 ; i<=numero; i++) {
		Numeros numerores= new Numeros();
		Respuesta respuesta= new Respuesta();
	
	String fooResourceUrl = "http://localhost:1337/numeros/"+i;
	ResponseEntity<Numeros> response= restTemplate.getForEntity(fooResourceUrl + "", Numeros.class);
	numerores.setNombreespanol(response.getBody().getNombreespanol());
	numerores.setNombremixteco(response.getBody().getNombremixteco());
	numerores.setValor1(response.getBody().getValor1());
	numerores.setValor2(response.getBody().getValor2());
	numerores.setValor3(response.getBody().getValor3());
	numerores.setTextok(response.getBody().getTextok());
	numerores.setTextok(response.getBody().getTextok());
	numerores.setActivad(response.getBody().getActivad());
	
	numerores.setPregunta1(response.getBody().getPregunta1());
	numerores.setPregunta2(response.getBody().getPregunta2());
	numerores.setPregunta3(response.getBody().getPregunta3());
	  
	      
	        int skaicius = (int) (Math.random() * 3 + 1);
	      System.out.print("-----------------"+skaicius);
	    
    
    
  

    System.out.println("XD numero "+response.getBody().getNombreespanol());
 //   String valor="";
    
  
 ///list_respuestas.add(valor);  
//	
	
 
	numerores.setRespuestas(list_respuestas);
	
	numerores.setUrlcorto("http://localhost:1337"+response.getBody().getImagen().get(0).getUrl());
	numerores.setAudiocorto("http://localhost:1337"+response.getBody().getAudio().get(0).getUrl());
	numeros_list.add(numerores);
	  list_uno.add(respuesta);
	}  
	model.addAttribute("list_resp", list_uno);
	model.addAttribute("numeros", numeros_list);
	
		return "nivel1/numeronivel1";
	}
	


	public List<String> aleatorio(boolean[] impresas,String[] ordenadas) {
		
		List<String> list_respuestas= new ArrayList<>();
	    for(int y = 0; y< ordenadas.length;){
      int posicion = (int)(Math.random() * ordenadas.length);
      if(!impresas[posicion]){
          impresas[posicion] = true;
          String valor=ordenadas[posicion];
         System.out.println(valor);
          
          
          list_respuestas.add(valor);
        //  System.out.println("XD "+response.getBody().getValorok());
          y++;
         
      }
  }
		
		return list_respuestas;
	}
	
}
