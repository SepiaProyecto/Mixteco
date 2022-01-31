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
import mx.curso.mixteco.model.PartesDelCuerpo;
import mx.curso.mixteco.model.Saludos;
import mx.curso.mixteco.repository.IEvaluacionService;

@Controller
@Slf4j
public class Nivel2Controller {

//	private final String host = "https://contenidostrapi.herokuapp.com";
	private final String host="http://localhost:1337";
	UserController nn = new UserController();
	@Autowired
	private IEvaluacionService iEvaluacionService;

	@PostMapping("/nivel2")
	public String nivel1(Model model,@ModelAttribute Usuario userglobal) {
	
		//log.info("--------nivel1usuario numero---------" + userglobal);
		model.addAttribute("usuario", userglobal);
		//log.info("--------nivel2 saludos---------");
		

		return "nivel2/nivel2";
	}

	
	@PostMapping("/saludosnivel2")
	public String numerosnivel1(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		log.info("--------nivel2 saludos---------");
		Usuario user = nn.nombreglobal();

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrlcontador = host + "/saludos/count?nivel=nivel2";

		ResponseEntity<String> contador = restTemplate.getForEntity(fooResourceUrlcontador + "", String.class);

	
		int numero = Integer.parseInt(contador.getBody());

		List<Saludos> numeros_list = new ArrayList<>();

		List<String> list_respuestas = new ArrayList<>();

		for (int i = 1; i <= numero; i++) {
			Saludos numerores = new Saludos();

			String fooResourceUrl = host + "/saludos/" + i;
			ResponseEntity<Saludos> response = restTemplate.getForEntity(fooResourceUrl + "", Saludos.class);
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

		model.addAttribute("saludos", numeros_list);

		return "nivel2/saludosnivel2";
	}
	// -------------------------------------

	
	// -------------------------------------

	@GetMapping("/evaluacion2")
	public String evaluacionnivel2(Model model,@ModelAttribute Usuario userglobal) {
	
		model.addAttribute("usuario", userglobal);
		
		model.addAttribute("evaluacions", iEvaluacionService.listEvaluacion());
		return "admin/examen";
	}
}
