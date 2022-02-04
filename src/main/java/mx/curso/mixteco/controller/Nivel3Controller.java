package mx.curso.mixteco.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.repository.IDialogRepository;
import mx.curso.mixteco.repository.IEvaluacionService;
import mx.curso.mixteco.repository.INivel3Service;



@Controller
@Slf4j
public class Nivel3Controller {
	
	@Autowired
	private IDialogRepository idialogService;
	@Autowired
	private INivel3Service iNivel3Service;
	
//	String host = "https://contenidostrapi.herokuapp.com";
	String host = "http://localhost:1337";
	
	@Autowired
	private IEvaluacionService iEvaluacionService;
	
	@GetMapping("/nivel3")
	public String nivel3 (@ModelAttribute Usuario userglobal, Model model) {
		
	
		 
		 log.info("into to nivel 3");
		return "nivel3/nivel3";
	}
	
	
	@GetMapping("/dialogo")
	public String dialogonivel3 (@ModelAttribute Usuario userglobal, Model model) {
		
		 model. addAttribute("dialogos", idialogService.listdialog("ejemplo1",1));
		 model. addAttribute("dialogo2", idialogService.listdialog("ejemplo1",2));
		 model. addAttribute("pregunta1", iNivel3Service.listEvaluacion(0));
		 model. addAttribute("audioem1", host+idialogService.listdialog("ejemplo1", 1).get(0).getAudio().get(0).getUrl());
		 model. addAttribute("receptor1", host+idialogService.listdialog("ejemplo1", 2).get(0).getAudio().get(0).getUrl());
		 
		 model. addAttribute("dialogoejemplo2", idialogService.listdialog("ejemplo2",3));
		 model. addAttribute("dialogoejemplo22", idialogService.listdialog("ejemplo2",4));
		 model. addAttribute("pregunta2", iNivel3Service.listEvaluacion(1));
		 model. addAttribute("audioem2", host+idialogService.listdialog("ejemplo2", 3).get(0).getAudio().get(0).getUrl());
		 model. addAttribute("receptor2", host+idialogService.listdialog("ejemplo2", 4).get(0).getAudio().get(0).getUrl());
		 
		 model. addAttribute("dialogoejemplo3", idialogService.listdialog("ejemplo3",5));
		 model. addAttribute("dialogoejemplo33", idialogService.listdialog("ejemplo3",6));
		 model. addAttribute("pregunta3", iNivel3Service.listEvaluacion(2));
		 model. addAttribute("audioem3", host+idialogService.listdialog("ejemplo3", 5).get(0).getAudio().get(0).getUrl());
		 model. addAttribute("receptor3", host+idialogService.listdialog("ejemplo3", 6).get(0).getAudio().get(0).getUrl());
		 
		 log.info("into to nivel 3");
		return "nivel3/dialogo";
	}

	@GetMapping("/examen3")
	public String examen3 (@ModelAttribute Usuario userglobal, Model model) {
		
	
			
			//model.addAttribute("usuario", userglobal);
			
			model.addAttribute("evaluacions", iEvaluacionService.listEvaluacion());
			return "admin/examen3";
	
	
	}
	
}
