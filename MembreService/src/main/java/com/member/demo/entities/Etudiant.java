package com.member.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;



@Getter
@Setter
@Entity 
@NoArgsConstructor
@DiscriminatorValue("etd")
public class Etudiant extends Membre{
	
	@NonNull
	private Date dateInscription;
	private String diplome;
	private String sujet;
	@ManyToOne
	private EnseignantChercheur encadrant;
	@Builder
	public Etudiant( String cin, String nom, String prenom, Date dateNaissance, String cv, String email, String password, Date dateInscription, String sujet, String
	diplome,EnseignantChercheur encadrant) {
	super(cin, nom, prenom, dateNaissance, cv, email, password);
	this.dateInscription = dateInscription;
	this.diplome = diplome;
	this.sujet = sujet;
	this.encadrant = encadrant;
	}

}
