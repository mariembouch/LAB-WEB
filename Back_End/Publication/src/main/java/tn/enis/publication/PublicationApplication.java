package tn.enis.publication;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tn.enis.publication.dao.PublicationRepository;
import tn.enis.publication.entities.Publication;

import java.util.Date;


@EnableDiscoveryClient
@SpringBootApplication
@AllArgsConstructor
public class PublicationApplication implements CommandLineRunner {
	PublicationRepository publicationRepository;
	public static void main(String[] args) {
		SpringApplication.run(PublicationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Publication pub1=Publication.builder()
				.type("typeA")
				.titre("pub1")
				.lien("ABC1")
				.date(new Date())
				.sourcepdf("pub1.pdf")
				.build();
		Publication pub2=Publication.builder()
				.type("typeA")
				.titre("pub1")
				.lien("ABC1")
				.date(new Date())
				.sourcepdf("pub1.pdf")
				.build();

		publicationRepository.save(pub1);
		publicationRepository.save(pub2);
	}
}
