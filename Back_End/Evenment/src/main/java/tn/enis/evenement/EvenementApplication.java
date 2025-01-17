package tn.enis.evenement;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tn.enis.evenement.dao.EvenementRepository;
import tn.enis.evenement.entity.Evenement;
import tn.enis.evenement.service.IEvenementService;

import java.util.Date;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@AllArgsConstructor
public class EvenementApplication implements CommandLineRunner {



    EvenementRepository evenementRepository ;

    public static void main(String[] args) {
        SpringApplication.run(EvenementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Evenement evenement1 = new Evenement("Événement 1", new Date(),new Date(), "Lieu 1");
//        Evenement evenement2 = new Evenement("Événement 2", new Date(),new Date(), "Lieu 2");
//
//        evenementRepository.save(evenement1);
//        evenementRepository.save(evenement2);

    }
}
