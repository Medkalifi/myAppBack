package fr.moha.myApp.batch.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.moha.myApp.batch.model.Publication;
import fr.moha.myApp.batch.repository.PublicationRepository;
@Component
public class PublicationItemWriter implements ItemWriter<Publication> {
	private static final Logger log = LoggerFactory.getLogger(PublicationItemWriter.class);

	@Autowired
	private PublicationRepository publicationRepository;
	@Override
	public void write(List<? extends Publication> list) throws Exception {
		
		publicationRepository.saveAll(list);
		
		
	}

}
