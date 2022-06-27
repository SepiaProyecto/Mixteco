package mx.curso.mixteco.controller;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.repository.IEvaluacionService;
import mx.curso.mixteco.repository.IuserRepository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;



@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private JdbcTemplate plantilla;
	@Autowired
	private IEvaluacionService iEvaluacionService;
	@Autowired
    private IuserRepository iuserRepository;
	
	public String agregar = "INSERT INTO usuariosepias "+
		"(id, nombre, apellidopaterno, apellidomaterno, sexo, edad, usuario, contrasena,published_at "+
				")"+
		"VALUES((select max(id)+1 from usuariosepias), ?, ?, ?, ?, ?, ?, ?,'2022-01-31 11:52:51.9');";
		
	public String eliminar = "DELETE FROM usuariosepias " + "WHERE id=?;";
	
	public String SELECT_ALL = "select id, nombre, apellidopaterno, apellidomaterno, sexo, edad, usuario, contrasena FROM usuariosepias ";
	public String editar = " UPDATE  usuariosepias  SET nombre=?, apellidopaterno=?, apellidomaterno=?, sexo=?, edad=?, usuario=? "
			+ " WHERE id= ? ";
	
	public String seleccionar = "SELECT id, nombre, apellidopaterno, apellidomaterno, sexo, edad, usuario, contrasena "
			+ " FROM usuariosepias " + "WHERE id=?;";
	
	
	
	private final String host = "https://contenidostrapi.herokuapp.com";


	//private final String host="http://localhost:1337";

	
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
	
    return "index";
	}

	
	/**
	 * no hace nada
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/juego")
	public String juego(@ModelAttribute Usuario user, Model model) {
	log.info("pagina de inicio"+user.getContrasena());
     
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
	 

	 if (userglobal.getUsuario().equals("admin")&& userglobal.getContrasena().equalsIgnoreCase("root")) {
		 Usuario user =new Usuario();
		 user.setApellidomaterno("DDD");
		 user.setNombre("name");
		 user.setCorreo("corre");
		 user.setSexo("DS"); user.setId(5);
		 List<Usuario> list_user=new ArrayList<>();
		 list_user.add(user);
		 
		 
		 List<Usuario> employees = plantilla.query(
			  SELECT_ALL,
			   new BeanPropertyRowMapper(Usuario.class));
			     

	
		 model. addAttribute("usuarios", employees);
		// model. addAttribute("usuarios", iuserRepository.list_user());
		// model. addAttribute("evaluacions", iEvaluacionService.listEvaluacion());
		 return "admin/admin"; 
	 }
	 
	 String login=host+"/usuariosepias?usuario="+userglobal.getUsuario()+"&contrasena="+userglobal.getContrasena();
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
	
	
	@PostMapping("/agregarUsuario")
	public String agregarU(@ModelAttribute Usuario userglobal, Model model) {
	
		log.info("kjhkjhkj"+userglobal);
		plantilla.update(agregar,userglobal.getNombre(),userglobal.getApellidopaterno(),userglobal.getApellidomaterno(),
				userglobal.getSexo(),userglobal.getEdad(),userglobal.getUsuario(),userglobal.getContrasena());
		 List<Usuario> employees = plantilla.query(
				  SELECT_ALL,
				   new BeanPropertyRowMapper(Usuario.class));
		 model. addAttribute("usuarios", employees);
		 Usuario uservacio=new Usuario();
		 model. addAttribute("usuario", uservacio);
		return "admin/admin";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editarU(@PathVariable(name="id") int id, @ModelAttribute Usuario userglobal, Model model) {
		log.info("editado "+id);
		Usuario usuario = 
		(Usuario) plantilla.queryForObject(seleccionar, new Object [] {id}, new BeanPropertyRowMapper(Usuario.class));
		userglobal.setNombre("Jose");
		userglobal.setApellidopaterno("Perez");
		userglobal.setApellidomaterno("Leon");
		userglobal.setEdad("10");
		userglobal.setSexo("M");
		model. addAttribute("usuario", usuario);
		return "admin/editar";
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarU(@PathVariable(name="id") int id, @ModelAttribute Usuario userglobal, Model model) {
		log.info("eliminado alv"+id);
		plantilla.update(eliminar,id);
		 List<Usuario> employees = plantilla.query(
				  SELECT_ALL,
				   new BeanPropertyRowMapper(Usuario.class));
		 model. addAttribute("usuarios", employees);

		return "admin/admin";
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarU(@ModelAttribute Usuario userglobal, Model model) {
		log.info("actualizado !"+userglobal);
		plantilla.update(editar,
				userglobal.getNombre(),
				userglobal.getApellidopaterno(),
				userglobal.getApellidomaterno(),
				userglobal.getSexo(),
				userglobal.getEdad(),
				userglobal.getUsuario(),
				userglobal.getContrasena(),
				userglobal.getId());
		
		 List<Usuario> employees = plantilla.query(
				  SELECT_ALL,
				   new BeanPropertyRowMapper(Usuario.class));
				     

		
			 model. addAttribute("usuarios", employees);
			 Usuario uservacio=new Usuario();
			 model. addAttribute("usuario", uservacio);
		return "admin/admin";
	}
	
	public Usuario nombreglobal( ) {
		Usuario user= new Usuario();
		return user;
	}
	
}
