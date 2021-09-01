package fr.moha.myApp.impression.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.moha.myApp.impression.service.ExportPdfService;
import fr.moha.myApp.model.Formation;
import fr.moha.myApp.service.FormationService;

@RestController
public class ImpressionController {
	
	@Autowired
	private ExportPdfService exportPdfService;
	
	@Autowired
	private FormationService formationService;
	
	@GetMapping("/export/pdf")
	public ResponseEntity<InputStreamResource> exportPDF() {
		List<Formation> formations = formationService.getFormations();
		ByteArrayInputStream bais = exportPdfService.formationsPDFReport(formations);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename = formations.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bais));

	}
	

}
