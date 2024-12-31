package com.member.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.member.demo.entities.EnseignantChercheur;
import com.member.demo.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
	List<Etudiant> findByDiplome(String diplome);
	List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
	List<Etudiant> findByEncadrant(EnseignantChercheur e);
}
