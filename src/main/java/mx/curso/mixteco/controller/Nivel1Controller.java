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
import mx.curso.mixteco.model.Acciones;
import mx.curso.mixteco.model.Animales;
import mx.curso.mixteco.model.Direcciones;
import mx.curso.mixteco.model.Familia;
import mx.curso.mixteco.model.FrutasYVerduras;
import mx.curso.mixteco.model.Hogar;
import mx.curso.mixteco.model.Numeros;
import mx.curso.mixteco.model.Otros;
import mx.curso.mixteco.model.PartesDelCuerpo;
import mx.curso.mixteco.repository.IEvaluacionService;

@Controller
@Slf4j
public class Nivel1Controller {

	private final String host = "https://contenidostrapi.herokuapp.com";
	//private final String host="http://localhost:1337";
	UserController nn = new UserController();
	@Autowired
	private IEvaluacionService iEvaluacionService;

	@PostMapping("/nivel1")
	public String nivel1(Model model,@ModelAttribute Usuario userglobal) {
	
		//log.info("--------nivel1usuario numero---------" + userglobal);
		model.addAttribute("usuario", userglobal);
		//log.info("--------nivel1 numero---------");
		

		return "nivel1/nivel1";
	}

	
	@PostMapping("/numeronivel1")
	public String numerosnivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 numeros---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrlcontador = host + "/numeros/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

	
		int numero = Integer.parseInt(contador.getBody());

		List<Numeros> numeros_list = new ArrayList<>();

		List<String> list_respuestas = new ArrayList<>();

		for (int i = 1; i <= numero; i++) {
			Numeros numerores = new Numeros();

			String fooResourceUrl = host + "/numeros/" + i;
			ResponseEntity<Numeros> response = restTemplate.getForEntity(fooResourceUrl + "", Numeros.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setActivad(response.getBody().getActivad());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

			numerores.setRespuestas(list_respuestas);

			numerores.setUrlcorto(host + response.getBody().getImagen().get(0).getUrl());
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);

		}

		model.addAttribute("numeros", numeros_list);

		return "nivel1/numeronivel1";
	}
	// -------------------------------------

	// Codigoparaanimal
	@PostMapping("/animalnivel1")
	public String animalnivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 animales---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();
		// cambiar url
		String fooResourceUrlcontador = host + "/animales/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		
		int animales = Integer.parseInt(contador.getBody());
		// importar la clase
		List<Animales> numeros_list = new ArrayList<>();

		for (int i = 1; i <= animales; i++) {
			Animales numerores = new Animales();

			// cambiar url
			String fooResourceUrl = host + "/animales/" + i;
			// cambiar a Animales
			ResponseEntity<Animales> response = restTemplate.getForEntity(fooResourceUrl + "", Animales.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

			numerores.setUrlcorto(host + response.getBody().getImagen().get(0).getUrl());
		
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);

		}
		// cambiar
		model.addAttribute("animales", numeros_list);
		// cambiar
		return "nivel1/animalnivel1";
	}

//--------------------

	// Codigoparafrutasyverduras
	@PostMapping("/frutasyverdurasnivel1")
	public String frutasyverdurasnivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 partes del cuerpo---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();
		// cambiar url
		String fooResourceUrlcontador = host + "/frutas-y-verduras/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		log.info("contador xd " + contador.getBody());
		int frutasyverduras = Integer.parseInt(contador.getBody());
		// importar la clase
		List<FrutasYVerduras> numeros_list = new ArrayList<>();

		for (int i = 1; i <= frutasyverduras; i++) {
			FrutasYVerduras numerores = new FrutasYVerduras();

			// cambiar url
			String fooResourceUrl = host + "/frutas-y-verduras/" + i;
			// cambiar a frutas y verduras
			ResponseEntity<FrutasYVerduras> response = restTemplate.getForEntity(fooResourceUrl + "",
					FrutasYVerduras.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

		

			numerores.setUrlcorto(host + response.getBody().getImagen().get(0).getUrl());
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);

		}
		// cambiar
		model.addAttribute("frutasyverduras", numeros_list);
		// cambiar
		return "nivel1/frutasyverdurasnivel1";

	}

	// --------------------

	// Codigo para el cuerpo humano
	@PostMapping("/partesdelcuerponivel1")
	public String partesDelCuerponivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 partes del cuerpo---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();
		// cambiar url
		String fooResourceUrlcontador = host + "/partes-del-cuerpos/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		log.info("contador xd " + contador.getBody());
		int partesdelcuerpo = Integer.parseInt(contador.getBody());
		// importar la clase
		List<PartesDelCuerpo> numeros_list = new ArrayList<>();

		for (int i = 1; i <= partesdelcuerpo; i++) {
			PartesDelCuerpo numerores = new PartesDelCuerpo();

			// cambiar url
			String fooResourceUrl = host + "/partes-del-cuerpos/" + i;
			// cambiar a frutas y verduras
			ResponseEntity<PartesDelCuerpo> response = restTemplate.getForEntity(fooResourceUrl + "",
					PartesDelCuerpo.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

			numerores.setUrlcorto(host + response.getBody().getImagen().get(0).getUrl());
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);
			// list_uno.add(respuesta);
		}
		// cambiar
		model.addAttribute("partesdelcuerpo", numeros_list);
		// cambiar
		return "nivel1/partesdelcuerponivel1";
	}

	// -----------------------

	// Codigo para el hogar
	@PostMapping("/hogarnivel1")
	public String hogarnivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 cosas del hogar--------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();
		// cambiar url
		String fooResourceUrlcontador = host + "/hogars/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		log.info("contador xd " + contador.getBody());
		int hogar = Integer.parseInt(contador.getBody());
		// importar la clase
		List<Hogar> numeros_list = new ArrayList<>();

		
		for (int i = 1; i <= hogar; i++) {
			Hogar numerores = new Hogar();

			// cambiar url
			String fooResourceUrl = host + "/hogars/" + i;
			// cambiar a frutas y verduras
			ResponseEntity<Hogar> response = restTemplate.getForEntity(fooResourceUrl + "", Hogar.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

			numerores.setUrlcorto(host+response.getBody().getImagen().get(0).getUrl());
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);

		}
		// cambiar
		model.addAttribute("hogar", numeros_list);
		// cambiar
		return "nivel1/hogarnivel1";
	}

	// -----------------------

	// Codigo para la familia
	@PostMapping("/familianivel1")
	public String familianivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 integrantes de la familia--------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();
		// cambiar url
		String fooResourceUrlcontador = host + "/familias/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		log.info("contador xd " + contador.getBody());
		int hogar = Integer.parseInt(contador.getBody());
		// importar la clase
		List<Familia> numeros_list = new ArrayList<>();

		for (int i = 1; i <= hogar; i++) {
			Familia numerores = new Familia();

			// cambiar url
			String fooResourceUrl = host + "/familias/" + i;
			// cambiar a
			ResponseEntity<Familia> response = restTemplate.getForEntity(fooResourceUrl + "", Familia.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

			numerores.setUrlcorto(host + response.getBody().getImagen().get(0).getUrl());
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);
			// list_uno.add(respuesta);
		}
		// cambiar
		model.addAttribute("familia", numeros_list);
		// cambiar
		return "nivel1/familianivel1";
	}

	// -----------------------

	@PostMapping("/direccionesnivel1")
	public String direccionesnivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 direcciones---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrlcontador = host + "/direcciones/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		log.info("contador xd " + contador.getBody());
		int numero = Integer.parseInt(contador.getBody());

		List<Direcciones> numeros_list = new ArrayList<>();

		List<String> list_respuestas = new ArrayList<>();

		for (int i = 1; i <= numero; i++) {
			Direcciones numerores = new Direcciones();

			String fooResourceUrl = host + "/direcciones/" + i;
			ResponseEntity<Direcciones> response = restTemplate.getForEntity(fooResourceUrl + "", Direcciones.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setActivad(response.getBody().getActivad());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

			numerores.setRespuestas(list_respuestas);

			numerores.setUrlcorto(host + response.getBody().getImagen().get(0).getUrl());
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);
		}

		model.addAttribute("direcciones", numeros_list);

		return "nivel1/direccionesnivel1";
	}
	// -------------------------------------
	
	@PostMapping("/otrosnivel1")
	public String otrosnivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel1 otros---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrlcontador = host + "/otros/count?nivel=nivel1";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		log.info("contador xd " + contador.getBody());
		int numero = Integer.parseInt(contador.getBody());

		List<Otros> numeros_list = new ArrayList<>();

		List<String> list_respuestas = new ArrayList<>();

		for (int i = 1; i <= numero; i++) {
			Otros numerores = new Otros();

			String fooResourceUrl = host + "/otros/" + i;
			ResponseEntity<Otros> response = restTemplate.getForEntity(fooResourceUrl + "", Otros.class);
			numerores.setNombre(response.getBody().getNombre());
			numerores.setValor1(response.getBody().getValor1());
			numerores.setValor2(response.getBody().getValor2());
			numerores.setValor3(response.getBody().getValor3());

			numerores.setActivad(response.getBody().getActivad());

			numerores.setPregunta1(response.getBody().getPregunta1());
			numerores.setPregunta2(response.getBody().getPregunta2());
			numerores.setPregunta3(response.getBody().getPregunta3());

			numerores.setRespuestas(list_respuestas);

			numerores.setUrlcorto(host + response.getBody().getImagen().get(0).getUrl());
			numerores.setAudiocorto(host + response.getBody().getAudio().get(0).getUrl());
			numeros_list.add(numerores);
		}

		model.addAttribute("otros", numeros_list);

		return "nivel1/otrosnivel1";
	}
	// -------------------------------------

	@GetMapping("/evaluacion")
	public String evaluacionnivel1(Model model,@ModelAttribute Usuario userglobal) {
	
		model.addAttribute("usuario", userglobal);
		
		model.addAttribute("evaluacions", iEvaluacionService.listEvaluacion());
		return "admin/examen";
	}
}
