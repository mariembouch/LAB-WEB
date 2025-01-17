package tn.enis.outil;

import java.util.Date;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


import tn.enis.outil.dao.OutilRepository;
import tn.enis.outil.entities.Outil;


import lombok.AllArgsConstructor;

@EnableDiscoveryClient
@SpringBootApplication
@AllArgsConstructor
public class OutilApplication implements CommandLineRunner{
	

	OutilRepository outilrepository;
	public static void main(String[] args) {
		SpringApplication.run(OutilApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//        Outil out1 = Outil.builder()
//                .date(new Date())
//                .source("Source 1")
//                .build();
//
//        Outil out2 = Outil.builder()
//                .date(new Date())
//                .source("Source 2")
//                .build();
//
//        outilrepository.save(out1);
//        outilrepository.save(out2);
    }
}
