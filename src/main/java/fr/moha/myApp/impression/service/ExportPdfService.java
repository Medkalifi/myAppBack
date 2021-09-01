package fr.moha.myApp.impression.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import fr.moha.myApp.model.Formation;
import fr.moha.myApp.service.FormationService;

@Service
public class ExportPdfService {
	
	@Autowired
	private FormationService formationService;
	
	public  ByteArrayInputStream formationsPDFReport(List<Formation> formations) {
		Document document = new Document();
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
		  try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
			Paragraph para = new Paragraph("Liste des formations suivi", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			PdfPTable table = new PdfPTable(4);
			Stream.of("Année début", "Année fin", "Lieu", "Description").forEach(entete->{
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase("headerTitle", headFont ));
			});
			 formations = formationService.getFormations();
			System.out.println(formations.size());
			for (Formation formation : formations) {
				PdfPCell anneeDebut = new PdfPCell(new Phrase(formation.getAnneeDebut().toString()));
				anneeDebut.setPaddingLeft(1);
				anneeDebut.setVerticalAlignment(Element.ALIGN_MIDDLE);
				anneeDebut.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(anneeDebut);
				PdfPCell anneeFin = new PdfPCell(new Phrase(formation.getAnneeFin().toString()));
				anneeDebut.setPaddingLeft(1);
				anneeDebut.setVerticalAlignment(Element.ALIGN_MIDDLE);
				anneeDebut.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(anneeFin);
				PdfPCell lieu = new PdfPCell(new Phrase(formation.getLieu()));
				anneeDebut.setPaddingLeft(1);
				anneeDebut.setVerticalAlignment(Element.ALIGN_MIDDLE);
				anneeDebut.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(lieu);
				PdfPCell intitule = new PdfPCell(new Phrase(formation.getIntitule()));
				anneeDebut.setPaddingLeft(1);
				anneeDebut.setVerticalAlignment(Element.ALIGN_MIDDLE);
				anneeDebut.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(intitule);
				document.add(table);
				
			}
			
			
			
			document.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ByteArrayInputStream(out.toByteArray());
		
	}

}
