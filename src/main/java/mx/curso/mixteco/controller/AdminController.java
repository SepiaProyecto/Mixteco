package mx.curso.mixteco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;

@Controller
@Slf4j
public class AdminController {

	
	@GetMapping("/userlist")
	public String index(Model model) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);
	
		return "index";
	}
	
}
