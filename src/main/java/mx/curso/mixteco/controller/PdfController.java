package mx.curso.mixteco.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lowagie.text.DocumentException;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;
import mx.curso.mixteco.service.PdfService;
@Slf4j
@Controller
public class PdfController {
	
	
	 private final PdfService pdfService;
	 
	   @Autowired
	    public PdfController(PdfService pdfService) {
	   
	        this.pdfService = pdfService;
	    }
	   
	 @GetMapping("/download-pdf")
	    public void downloadPDFResource(HttpServletResponse response,@ModelAttribute Usuario userglobal) {
		 
		 log.info("user reportepdf "+userglobal.getUsuario());
	        try {
	            Path file = Paths.get(pdfService.generatePdf(userglobal).getAbsolutePath());
	            if (Files.exists(file)) {
	                response.setContentType("application/pdf");
	                response.addHeader("Content-Disposition",
	                        "attachment; filename=" + file.getFileName());
	                Files.copy(file, response.getOutputStream());
	                response.getOutputStream().flush();
	            }
	        } catch (DocumentException | IOException ex) {
	            ex.printStackTrace();
	        }
	    }

}
