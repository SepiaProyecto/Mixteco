
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
import mx.curso.mixteco.model.CreandoOraciones;
import mx.curso.mixteco.model.CreandoPreguntas;
import mx.curso.mixteco.model.Pronombres;
import mx.curso.mixteco.model.PronombresInterrogativos;
import mx.curso.mixteco.model.RespuestasComunes;
import mx.curso.mixteco.model.VerbosFuturoTYEN;
import mx.curso.mixteco.model.VerbosFuturoUE;
import mx.curso.mixteco.model.VerbosPasadoTYEN;
import mx.curso.mixteco.model.VerbosPasadoUE;
import mx.curso.mixteco.model.VerbosPresenteTYEN;
import mx.curso.mixteco.model.VerbosPresenteUE;
import mx.curso.mixteco.repository.IEvaluacionService;
/**
 * @author Ernesto
 * @version 1.0.0
 * @descripcion La arquitectura vista - controlador, la clase es la capa del controlador
 * realiza la conexion del front - capa de servicio.
 */
@Controller
@Slf4j
public class Nivel2Controller {

 	private final String host = "https://contenidostrapi.herokuapp.com";
	//private final String host="http://localhost:1337";
	UserController nn = new UserController();
	@Autowired
	private IEvaluacionService iEvaluacionService;

	@PostMapping("/nivel2")
	public String nivel1(Model model,@ModelAttribute Usuario userglobal) {
	
		//log.info("--------nivel1usuario numero---------" + userglobal);
		model.addAttribute("usuario", userglobal);
		//log.info("--------nivel2 saludos ---------");
		

		return "nivel2/nivel2";
	}

	
	@PostMapping("/pronombresnivel2")
	public String pronombresnivel2(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel2 pronombres---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrlcontador = host + "/pronombres/count?nivel=nivel2";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

	
		int numero = Integer.parseInt(contador.getBody());

		List<Pronombres> numeros_list = new ArrayList<>();

		List<String> list_respuestas = new ArrayList<>();

		for (int i = 1; i <= numero; i++) {
			Pronombres numerores = new Pronombres();

			String fooResourceUrl = host + "/pronombres/" + i;
			ResponseEntity<Pronombres> response = restTemplate.getForEntity(fooResourceUrl + "", Pronombres.class);
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

		model.addAttribute("pronombres", numeros_list);

		return "nivel2/pronombresnivel2";
	}
	// -------------------------------------
	@PostMapping("/verbospresentetyen")
	public String verbospresentetyen(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel2 verbos presente---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrlcontador = host + "/presentetyens/count?nivel=nivel2";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

	
		int numero = Integer.parseInt(contador.getBody());

		List<VerbosPresenteTYEN> numeros_list = new ArrayList<>();

		List<String> list_respuestas = new ArrayList<>();

		for (int i = 1; i <= numero; i++) {
			VerbosPresenteTYEN numerores = new VerbosPresenteTYEN();

			String fooResourceUrl = host + "/presentetyens/" + i;
			ResponseEntity<VerbosPresenteTYEN> response = restTemplate.getForEntity(fooResourceUrl + "", VerbosPresenteTYEN.class);
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

		model.addAttribute("verbospresente", numeros_list);

		return "nivel2/verbospresentetyen";
	}
	
	// -------------------------------------
	@PostMapping("/verbospasadotyen")
	public String verbospasadotyen(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel2 verbos pasado--------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrlcontador = host + "/pasadotyens/count?nivel=nivel2";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

	
		int numero = Integer.parseInt(contador.getBody());

		List<VerbosPasadoTYEN> numeros_list = new ArrayList<>();

		List<String> list_respuestas = new ArrayList<>();

		for (int i = 1; i <= numero; i++) {
			VerbosPasadoTYEN numerores = new VerbosPasadoTYEN();

			String fooResourceUrl = host + "/pasadotyens/" + i;
			ResponseEntity<VerbosPasadoTYEN> response = restTemplate.getForEntity(fooResourceUrl + "", VerbosPasadoTYEN.class);
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

		model.addAttribute("verbospasado", numeros_list);

		return "nivel2/verbospasadotyen";
	}
	
	// -------------------------------------
		@PostMapping("/verbosfuturotyen")
		public String verbosfuturotyen(Model model) {
			Usuario usuario = new Usuario();
			model.addAttribute("usuario", usuario);
			log.info("--------nivel2 verbos futuro--------");
			Usuario user = nn.nombreglobal();

			RestTemplate restTemplate = new RestTemplate();

			String fooResourceUrlcontador = host + "/futurotyens/count?nivel=nivel2";

			ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

		
			int numero = Integer.parseInt(contador.getBody());

			List<VerbosFuturoTYEN> numeros_list = new ArrayList<>();

			List<String> list_respuestas = new ArrayList<>();

			for (int i = 1; i <= numero; i++) {
				VerbosFuturoTYEN numerores = new VerbosFuturoTYEN();

				String fooResourceUrl = host + "/futurotyens/" + i;
				ResponseEntity<VerbosFuturoTYEN> response = restTemplate.getForEntity(fooResourceUrl + "", VerbosFuturoTYEN.class);
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

			model.addAttribute("verbosfuturo", numeros_list);

			return "nivel2/verbosfuturotyen";
		}
		// -------------------------------------
				@PostMapping("/verbospresenteue")
				public String verbospresenteue(Model model) {
					Usuario usuario = new Usuario();
					model.addAttribute("usuario", usuario);
					log.info("--------nivel2 verbos presente (Ustedes, Ellos)--------");
					Usuario user = nn.nombreglobal();

					RestTemplate restTemplate = new RestTemplate();

					String fooResourceUrlcontador = host + "/presenteues/count?nivel=nivel2";

					ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

				
					int numero = Integer.parseInt(contador.getBody());

					List<VerbosPresenteUE> numeros_list = new ArrayList<>();

					List<String> list_respuestas = new ArrayList<>();

					for (int i = 1; i <= numero; i++) {
						VerbosPresenteUE numerores = new VerbosPresenteUE();

						String fooResourceUrl = host + "/presenteues/" + i;
						ResponseEntity<VerbosPresenteUE> response = restTemplate.getForEntity(fooResourceUrl + "", VerbosPresenteUE.class);
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

					model.addAttribute("verbospresenteue", numeros_list);

					return "nivel2/verbospresenteue";
				}
				
				// -------------------------------------
				@PostMapping("/verbospasadoue")
				public String verbospasadoue(Model model) {
					Usuario usuario = new Usuario();
					model.addAttribute("usuario", usuario);
					log.info("--------nivel2 verbos pasado (Ustedes, Ellos)--------");
					Usuario user = nn.nombreglobal();

					RestTemplate restTemplate = new RestTemplate();

					String fooResourceUrlcontador = host + "/pasadoues/count?nivel=nivel2";

					ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

				
					int numero = Integer.parseInt(contador.getBody());

					List<VerbosPasadoUE> numeros_list = new ArrayList<>();

					List<String> list_respuestas = new ArrayList<>();

					for (int i = 1; i <= numero; i++) {
						VerbosPasadoUE numerores = new VerbosPasadoUE();

						String fooResourceUrl = host + "/pasadoues/" + i;
						ResponseEntity<VerbosPasadoUE> response = restTemplate.getForEntity(fooResourceUrl + "", VerbosPasadoUE.class);
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

					model.addAttribute("verbospasadoue", numeros_list);

					return "nivel2/verbospasadoue";
				}
	
				// -------------------------------------
				@PostMapping("/verbosfuturoue")
				public String verbosfuturoue(Model model) {
					Usuario usuario = new Usuario();
					model.addAttribute("usuario", usuario);
					log.info("--------nivel2 verbos futuro (Ustedes, Ellos)--------");
					Usuario user = nn.nombreglobal();

					RestTemplate restTemplate = new RestTemplate();

					String fooResourceUrlcontador = host + "/futuroues/count?nivel=nivel2";

					ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

				
					int numero = Integer.parseInt(contador.getBody());

					List<VerbosFuturoUE> numeros_list = new ArrayList<>();

					List<String> list_respuestas = new ArrayList<>();

					for (int i = 1; i <= numero; i++) {
						VerbosFuturoUE numerores = new VerbosFuturoUE();

						String fooResourceUrl = host + "/futuroues/" + i;
						ResponseEntity<VerbosFuturoUE> response = restTemplate.getForEntity(fooResourceUrl + "", VerbosFuturoUE.class);
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

					model.addAttribute("verbosfuturoue", numeros_list);

					return "nivel2/verbosfuturoue";
				}
				
				// -------------------------------------
				
				// -------------------------------------
				@PostMapping("/creandoraciones")
				public String creandoraciones(Model model) {
					Usuario usuario = new Usuario();
					model.addAttribute("usuario", usuario);
					log.info("--------nivel2 creando oraciones--------");
					Usuario user = nn.nombreglobal();

					RestTemplate restTemplate = new RestTemplate();

					String fooResourceUrlcontador = host + "/creand-oraciones/count?nivel=nivel2";

					ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

				
					int numero = Integer.parseInt(contador.getBody());

					List<CreandoOraciones> numeros_list = new ArrayList<>();

					List<String> list_respuestas = new ArrayList<>();

					for (int i = 1; i <= numero; i++) {
						CreandoOraciones numerores = new CreandoOraciones();
						

						String fooResourceUrl = host + "/creand-oraciones/" + i;
						ResponseEntity<CreandoOraciones> response = restTemplate.getForEntity(fooResourceUrl + "", CreandoOraciones.class);
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

					model.addAttribute("creandoraciones", numeros_list);

					return "nivel2/creandoraciones";
				}
				
				// -------------------------------------
				
				@PostMapping("/pronombresinte")
				public String pronombresinte(Model model) {
					Usuario usuario = new Usuario();
					model.addAttribute("usuario", usuario);
					log.info("--------nivel2 pronombres interrogativos--------");
					Usuario user = nn.nombreglobal();

					RestTemplate restTemplate = new RestTemplate();

					String fooResourceUrlcontador = host + "/pronombres-interrogativos/count?nivel=nivel2";

					ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

				
					int numero = Integer.parseInt(contador.getBody());

					List<PronombresInterrogativos> numeros_list = new ArrayList<>();

					List<String> list_respuestas = new ArrayList<>();

					for (int i = 1; i <= numero; i++) {
						PronombresInterrogativos numerores = new PronombresInterrogativos();
						

						String fooResourceUrl = host + "/pronombres-interrogativos/" + i;
						ResponseEntity<PronombresInterrogativos> response = restTemplate.getForEntity(fooResourceUrl + "", PronombresInterrogativos.class);
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

					model.addAttribute("pronombresinte", numeros_list);

					return "nivel2/pronombresinte";
				}
				
				// -------------------------------------
				@PostMapping("/creandopreguntas")
				public String creandopreguntas(Model model) {
					Usuario usuario = new Usuario();
					model.addAttribute("usuario", usuario);
					log.info("--------nivel2 plantea preguntas-------");
					Usuario user = nn.nombreglobal();

					RestTemplate restTemplate = new RestTemplate();

					String fooResourceUrlcontador = host + "/crearpreguntas/count?nivel=nivel2";
					log.info(fooResourceUrlcontador);
					ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

				
					int numero = Integer.parseInt(contador.getBody());

					List<CreandoPreguntas> numeros_list = new ArrayList<>();

					List<String> list_respuestas = new ArrayList<>();

					for (int i = 1; i <= numero; i++) {
						CreandoPreguntas numerores = new CreandoPreguntas();
						

						String fooResourceUrl = host + "/crearpreguntas/" + i;
						log.info(fooResourceUrl);
						ResponseEntity<CreandoPreguntas> response = restTemplate.getForEntity(fooResourceUrl + "", CreandoPreguntas.class);
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
					
					model.addAttribute("creandopreguntas", numeros_list);

					return "nivel2/creandopreguntas";
				}
				
				
				// -------------------------------------
				@PostMapping("/respuestas")
				public String respuestas(Model model) {
					Usuario usuario = new Usuario();
					model.addAttribute("usuario", usuario);
					log.info("--------nivel2 plantea preguntas-------");
					Usuario user = nn.nombreglobal();

					RestTemplate restTemplate = new RestTemplate();

					String fooResourceUrlcontador = host + "/respuestas-comunes/count?nivel=nivel2";

					ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

				
					int numero = Integer.parseInt(contador.getBody());

					List<RespuestasComunes> numeros_list = new ArrayList<>();

					List<String> list_respuestas = new ArrayList<>();

					for (int i = 1; i <= numero; i++) {
						RespuestasComunes numerores = new RespuestasComunes();
						

						String fooResourceUrl = host + "/respuestas-comunes/" + i;
						ResponseEntity<RespuestasComunes> response = restTemplate.getForEntity(fooResourceUrl + "", RespuestasComunes.class);
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

					model.addAttribute("respuestas", numeros_list);

					return "nivel2/respuestas";
				}
				
	@GetMapping("/evaluacion2")
	public String evaluacionnivel2(Model model,@ModelAttribute Usuario userglobal) {
	
		model.addAttribute("usuario", userglobal);
		
		model.addAttribute("evaluacions", iEvaluacionService.listEvaluacion());
		return "admin/examen";
	}
}
