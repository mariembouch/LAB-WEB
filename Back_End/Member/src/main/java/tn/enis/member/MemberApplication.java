package tn.enis.member;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tn.enis.member.beans.EvenementBean;
import tn.enis.member.beans.OutilBean;
import tn.enis.member.beans.PublicationBean;
import tn.enis.member.dao.MemberRepository;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;
import tn.enis.member.entities.Member;
import tn.enis.member.services.IMemberService;


import java.util.Date;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class MemberApplication implements CommandLineRunner {
	MemberRepository memberRepository;
	IMemberService membreService;
	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

	}


}
