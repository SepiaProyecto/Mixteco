package mx.curso.mixteco.controller;



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
import mx.curso.mixteco.repository.IEvaluacionService;
import mx.curso.mixteco.repository.IuserRepository;



@Controller
@Slf4j
public class UserController {
	@Autowired
	private IEvaluacionService iEvaluacionService;
	@Autowired
    private IuserRepository iuserRepository;
	
	
	public Usuario userG=new Usuario();
	public String userr="xd";
	
//	private final String host = "https://contenidostrapi.herokuapp.com";
	private final String host="http://localhost:1337";
	
	@GetMapping("/")
		public String index(Model model) {
		Usuario usuario= new Usuario();
	    model.addAttribute("usuario",usuario);
	    log.info("saliedo login");
		
	    return "index";
		}
	
	@GetMapping("/salir")
	public String indexsalir(Model model) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);
    log.info("saliedo login");
	
    return "/index";
	}

	
	/**
	 * no hace nada
	 * @param user
	 * @param model
	 * @return
	 */
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
	public String login(@ModelAttribute Usuario userglobal, Model model) {

     
	 model. addAttribute("usuario", userglobal);

	 userG=new Usuario(); 
	 userG.setNombre(userglobal.getNombre());
	 userG.setUser(userglobal.getUser());
	this.userr=userglobal.getUser();
	nombreglobal( );
	log.info("user logininicio "+userr);
	 if (userglobal.getUser().equals("admin")&& userglobal.getPass().equalsIgnoreCase("root")) {
		 model. addAttribute("usuarios", iuserRepository.list_user());
		 model. addAttribute("evaluacions", iEvaluacionService.listEvaluacion());
		 return "admin/admin"; 
	 }
	 
	 String login=host+"/usersepias?user="+userglobal.getUser()+"&pass="+userglobal.getPass();
	 RestTemplate restTemplate = new RestTemplate();
	 ResponseEntity<Usuario[]> userlogin
	  = restTemplate.getForEntity(login ,Usuario[].class);

	log.info("XD userlogin "+userlogin.getBody().length);
	
	
	 if(userlogin.getBody().length<=0) {
		 model.addAttribute("usuarioinvalid","Datos invalidos");
		 return "index";
	 }else {
		 return "nivel1/index";
	 }
	
	
	}
	
	public Usuario nombreglobal( ) {
		Usuario user= new Usuario();
				log.info("usuarioglobal "+userr);
			
		user.setUser(userr);
		return user;
	}
	
}
