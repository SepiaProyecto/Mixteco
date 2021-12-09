package mx.curso.mixteco.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.model.Animal;
import mx.curso.mixteco.repository.IuserRepository;



@Controller
@Slf4j
public class UserController {

	@Autowired
    private IuserRepository iuserRepository;
	
	@GetMapping("/")
		public String index(Model model) {
		Usuario usuario= new Usuario();
	    model.addAttribute("usuario",usuario);
		
			return "index";
		}
	
	
	
	@PostMapping("/juego")
	public String juego(@ModelAttribute Usuario user, Model model) {
	log.info("pagina de inicio"+user.getPass());
     
	 model. addAttribute("usuario", user);
	
		 return "juego/juego";
	 
	
	
	}
	
	/**
	 * validadacion de usuarios
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/juegonivel")
	public String login(@ModelAttribute Usuario user, Model model) {
	log.info("pagina de inicio"+user.getPass());
     
	 model. addAttribute("usuario", user);
	 
	 
	 Usuario userglobal=new  Usuario();
	 userglobal.setNombre("pasoglobal");
	 nombreglobal();
	 
	 if (user.getUser().equals("admin")&& user.getPass().equalsIgnoreCase("root")) {
		 model. addAttribute("usuarios", iuserRepository.list_user());
		 return "admin/admin"; 
	 }
	 
	 String login="http://localhost:1337/usersepias?user="+user.getUser()+"&pass="+user.getPass();
	 RestTemplate restTemplate = new RestTemplate();
	 ResponseEntity<Usuario[]> userlogin
	  = restTemplate.getForEntity(login ,Usuario[].class);

	log.info("XD userlogin "+userlogin.getBody().length);
	
	Usuario[] employees = userlogin.getBody();
	
	
	for (Usuario o : employees) {
		log.info("XD userlogin vvvv "+o.getNombre());
		}
	
	 if(userlogin.getBody().length<=0) {
		 model.addAttribute("usuarioinvalid","Datos invalidos");
		 return "index";
	 }else {
		 return "nivel1/index";
	 }
	
	
	}
	
	public Usuario nombreglobal() {
				log.info("XD userlogin  global");
		return new Usuario();
	}
	

	

	@GetMapping("/animal")
	public String animales(Model model) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);

    RestTemplate restTemplate = new RestTemplate();
    
	String fooResourceUrlcontador
	  = "http://localhost:1337/animals/count";
	
	ResponseEntity<String> contador
	  = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

	log.info("XD"+contador.getBody());
	int numero=Integer.parseInt(contador.getBody());
	
    List<Animal> animales=new ArrayList<>();
   
    List<String> list_respuestas=new ArrayList<>();
    
	for (int i=1 ; i<=numero; i++) {
		Animal animal= new Animal();

	String fooResourceUrl = "http://localhost:1337/animals/"+i;
	ResponseEntity<Animal> response= restTemplate.getForEntity(fooResourceUrl + "", Animal.class);
	animal.setNombreespanol(response.getBody().getNombreespanol());


	animal.setValorok(response.getBody().getValorok());
	animal.setValornotok(response.getBody().getValornotok());
	animal.setValornotok1(response.getBody().getValornotok1());
	animal.setActivad(response.getBody().getActivad());
//	
//	list_respuestas.add(response.getBody().getValorok());
//	list_respuestas.add(response.getBody().getValornotok());
//	list_respuestas.add(response.getBody().getValornotok1());
	
//	String[] ordenadas = {response.getBody().getValorok(),response.getBody().getValornotok(), response.getBody().getValornotok1()};
//    boolean[] impresas = new boolean[ordenadas.length];
//
//    System.out.println("XD "+response.getBody().getValorok());
//    for(int y = 0; y< ordenadas.length;){
//        int posicion = (int)(Math.random() * ordenadas.length);
//        if(!impresas[posicion]){
//            impresas[posicion] = true;
//            String valor=ordenadas[posicion];
//          //  System.out.println(valor);
//            
//            
//            list_respuestas.add(valor);
//          //  System.out.println("XD "+response.getBody().getValorok());
//            y++;
//           
//        }
//    }
//	
	
	
	animal.setRespuestas(list_respuestas);
	
	animal.setUrlcorto("http://localhost:1337"+response.getBody().getImagen().get(0).getUrl());
	animal.setAudiocorto("http://localhost:1337"+response.getBody().getAudio().get(0).getUrl());
	animales.add(animal);
	
	}
	
	
	 model.addAttribute("animales", animales);
		return "nivel1/animal";
	}

	
	
	
}
