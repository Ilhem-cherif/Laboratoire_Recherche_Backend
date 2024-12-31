package com.example.publication.services;

import java.util.List;

import com.example.publication.entities.Publication;


public interface IPublicationService {
	public Publication addPublication(Publication p);
	public void deletePublication(Long id) ;
	public Publication updatePublication(Publication p) ;
	public Publication findPublication(Long id) ;
	public List<Publication> findAll();

}
