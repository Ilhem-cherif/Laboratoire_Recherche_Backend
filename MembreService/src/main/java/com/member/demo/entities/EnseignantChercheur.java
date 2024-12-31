package com.member.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor 
@Entity 
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre{
	
	private String grade;
	private String etablissement;
	@Builder
	public EnseignantChercheur( String cin, String nom, String prenom, Date dateNaissance, String cv, String email, 
			String password, String grade, String etablissement) {
	super(cin, nom, prenom, dateNaissance, cv, email, password);
	this.grade=grade;
	this.etablissement=etablissement;
	}
}
