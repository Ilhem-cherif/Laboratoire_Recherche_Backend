package com.member.demo.services;

import java.util.List;

import com.member.demo.beans.PublicationBean;
import com.member.demo.entities.EnseignantChercheur;
import com.member.demo.entities.Etudiant;
import com.member.demo.entities.Membre;

public interface IMemberService {
	//Crud sur les membres
	public Membre addMember(Membre m);
	public void deleteMember(Long id) ;
	public Membre updateMember(Membre p) ;
	public Membre findMember(Long id) ;
	public List<Membre> findAll();
	//Filtrage par propriété
	public Membre findByCin(String cin);
	public Membre findByEmail(String email);
	public List<Membre> findByNom(String nom);
	//recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);
	//recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);
	public List<EnseignantChercheur> findByEtablissement(String
	etablissement);
	public void affecterEtudiantToEnseignant(Long studentId, Long teacherId);
	public List<Etudiant> getEtudiantsByEnseignant(Long teacherId);
	
	public void affecterauteurTopublication(Long idauteur, Long idpub);
	public List<PublicationBean> findPublicationparauteur (Long idauteur);
}
