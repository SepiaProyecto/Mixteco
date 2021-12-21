package mx.curso.mixteco.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.model.Animales;



@Controller
@Slf4j
public class Nivel2Controller {
	

	@PostMapping("/nivel2")
	public String nivel1(Model model) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);
	log.info("--------nivel2---------");
		return "nivel2/nivel2";
	}
	
	
	@PostMapping("/numeronivel2")
	public String nivel2Numero(Model model) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);
	log.info("--------nivel2 numero---------");
		return "nivel2/numeronivel2";
	}
}
