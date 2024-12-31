package com.member.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.member.demo.beans.PublicationBean;
import com.member.demo.dao.MembreRepository;
import com.member.demo.entities.EnseignantChercheur;
import com.member.demo.entities.Etudiant;
import com.member.demo.proxies.PublicationServiceProxy;
import com.member.demo.services.IMemberService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class MembreServiceApplication implements CommandLineRunner{
	
	private final MembreRepository membreRepository;
	private final PublicationServiceProxy pubproxy;
	private final IMemberService membreService;
	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Etudiant etd1=Etudiant.builder()
				.cin("123456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("youssef@gmail.com")
				.password("pass1")
				.encadrant(null)
				.cv("cv1")
				.nom("abid")
				.prenom("youssef")
				.sujet("blockhain")
				.build();
		Etudiant etd2=Etudiant.builder()
				.cin("121256")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("ilhem@gmail.com")
				.password("ilhem")
				.encadrant(null)
				.cv("cv2")
				.nom("cherif")
				.prenom("ilhem")
				.sujet("devops")
				.build();
		EnseignantChercheur ens1 = EnseignantChercheur.builder()
				.cin("456987")
				.dateNaissance(new Date())
				.email("mohamed@gmail.com")
				.password("pass2")
				.cv("cv3")
				.nom("cherif")
				.prenom("mohamed")
				.grade("grade1")
				.etablissement("Enis")
				.build();
		EnseignantChercheur ens2 = EnseignantChercheur.builder()
				.cin("456265")
				.dateNaissance(new Date())
				.email("mariem@gmail.com")
				.password("pass3")
				.cv("cv4")
				.nom("cherif")
				.prenom("mariem")
				.grade("grade3")
				.etablissement("Enis")
				.build();
		
		membreRepository.save(etd1);
		membreRepository.save(etd2);
		membreRepository.save(ens1);
		membreRepository.save(ens2);
		
		PublicationBean pub1 = pubproxy.findPublicationById(1L);
		System.out.println(pub1.getType() + " " + pub1.getLien());
		membreService.affecterauteurTopublication(1L, 1L);		
		
	}

}
