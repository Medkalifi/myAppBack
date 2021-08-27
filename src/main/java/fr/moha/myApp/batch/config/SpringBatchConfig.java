package fr.moha.myApp.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import fr.moha.myApp.batch.model.Publication;
import fr.moha.myApp.config.JobCompletionNotificationListener;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private ItemReader<Publication> publicationItemReader;
	@Autowired
	private ItemWriter<Publication> publicationItemWriter;
	@Autowired
	private ItemProcessor<Publication, Publication> publicationItemProcessor;

	@Bean
	public Job publicationJob(JobCompletionNotificationListener listener) {
		Step step = stepBuilderFactory.get("step-load-data")
				.<Publication, Publication>chunk(100)
				.reader(publicationItemReader)
				.processor(publicationItemProcessor)
				.writer(publicationItemWriter)
				.listener(listener)
				.build();
		return jobBuilderFactory.get("publication-data-loader-job")
				.start(step)
				.build();
	}

	@Bean
	public FlatFileItemReader<Publication> flatFileItemReader(@Value("${inputFile}") Resource inputFile) {
		FlatFileItemReader<Publication> fileItemReader = new FlatFileItemReader<Publication>();
		fileItemReader.setName("FFIR1");
		fileItemReader.setLinesToSkip(1);
		fileItemReader.setResource(inputFile);
		fileItemReader.setLineMapper(lineMapper());
		return fileItemReader;
	}

	@Bean
	public LineMapper<Publication> lineMapper() {
		DefaultLineMapper<Publication> lineMapper = new DefaultLineMapper<Publication>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "titre", "journal", "anneePublicationStr", "auteur", "volume", "pageDebut",
				"pageFin");
		lineMapper.setLineTokenizer(lineTokenizer);
		BeanWrapperFieldSetMapper<Publication> fieldSetMapper = new BeanWrapperFieldSetMapper<Publication>();
		fieldSetMapper.setTargetType(Publication.class);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

	

}
