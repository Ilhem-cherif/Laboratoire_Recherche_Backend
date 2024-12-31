package com.example.evenement.services;

import java.util.List;

import com.example.evenement.entities.Evenement;

public interface IEvenementService {
	public Evenement addEvenement(Evenement e);
	public void deleteEvenement(Long id) ;
	public Evenement updateEvenement(Evenement e) ;
	public Evenement findEvenement(Long id) ;
	public List<Evenement> findAll();

}
