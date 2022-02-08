package mx.curso.mixteco.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import lombok.extern.slf4j.Slf4j;
import mx.curso.mixteco.entity.Usuario;

@Slf4j
@Service
public class PdfService {

    private static final String PDF_RESOURCES = "/pdf-resources/";
    private StudentService studentService;
    private SpringTemplateEngine templateEngine;

    @Autowired
    public PdfService(StudentService studentService, SpringTemplateEngine templateEngine) {
        this.studentService = studentService;
        this.templateEngine = templateEngine;
    }

    public File generatePdf(Usuario user) throws IOException, DocumentException {
        Context context = getContext(user);
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }


    private File renderPdf(String html) throws DocumentException, IOException {
        File file = File.createTempFile("students", ".pdf");
        OutputStream outputStream;
		try {
			 = new FileOutputStream(file);
			 ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
		        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
		        renderer.layout();
		        renderer.createPDF(outputStream);
		        outputStream.close();
		        file.deleteOnExit();
		} catch (FileNotFoundException e) {
		log.error(e.getMessage());
		}
		finally {
			outputStream.close();
		  }
        return file;
    }

    private Context getContext(Usuario user) {
        Context context = new Context();
        context.setVariable("students", studentService.getUsuario(user));
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("verpdf", context);
    }

    

}
