package mx.curso.mixteco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.repository.IEvaluacionService;

@Controller
@Slf4j
public class AdminController {

	
	@Autowired
	private IEvaluacionService iEvaluacionService;
	
	@GetMapping("/userlist/{cal}")
	public String index(Model model,@PathVariable("cal") String calificacion) {
	Usuario usuario= new Usuario();
    model.addAttribute("usuario",usuario);
			log.info("Generacion de reporte"+calificacion);
			 model. addAttribute("calificacion", calificacion);
			 model. addAttribute("evaluacions", iEvaluacionService.listEvaluacion());
		return "admin/report";
	}
	
	
}
