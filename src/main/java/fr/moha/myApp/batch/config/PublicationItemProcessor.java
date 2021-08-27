package fr.moha.myApp.batch.config;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import fr.moha.myApp.batch.model.Publication;

@Component
public class PublicationItemProcessor implements ItemProcessor<Publication, Publication> {
	private static final Logger log = LoggerFactory.getLogger(PublicationItemProcessor.class);

	@Override
	public Publication process(Publication publication) throws Exception {

		String dateStr = publication.getAnneePublicationStr();

		publication.setAnneePublication(LocalDate.parse(dateStr));
		
		log.info("Converting (" + publication.getAnneePublicationStr() + ") En  (" + publication.getAnneePublication() + ")");
		return publication;
	}

}
