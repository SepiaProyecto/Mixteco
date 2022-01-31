package mx.curso.mixteco.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.repository.IDialogRepository;



@Controller
@Slf4j
public class Nivel3Controller {
	
	@Autowired
	private IDialogRepository idialogService;
	@GetMapping("/nivel3")
	public String nivel3 (@ModelAttribute Usuario userglobal, Model model) {
		
		 model. addAttribute("dialogos", idialogService.listdialog("ejemplo1",1));
		 model. addAttribute("dialogo2", idialogService.listdialog("ejemplo1",2));
		 
		 
		 model. addAttribute("dialogoejemplo2", idialogService.listdialog("ejemplo2",3));
		 model. addAttribute("dialogoejemplo22", idialogService.listdialog("ejemplo2",4));
		 
		 model. addAttribute("dialogoejemplo3", idialogService.listdialog("ejemplo3",5));
		 model. addAttribute("dialogoejemplo33", idialogService.listdialog("ejemplo3",6));
		 
		 log.info("into to nivel 3");
		return "nivel3/nivel3";
	}
	

}
