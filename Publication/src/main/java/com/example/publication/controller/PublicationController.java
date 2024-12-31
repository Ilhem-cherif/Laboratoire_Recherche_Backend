package com.example.publication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.publication.entities.Publication;
import com.example.publication.services.IPublicationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/publications")
public class PublicationController {
	
private final IPublicationService publicationService;
	
	@GetMapping("/")
	public List<Publication> findPublication(){
		return publicationService.findAll();
	}
	@GetMapping(value="/{id}")
	public Publication findOnePublicationById(@PathVariable Long id) {
		return publicationService.findPublication(id);
	}
	@PostMapping(value="/publication")
	public Publication addPublication(@RequestBody Publication e)
	{
	return publicationService.addPublication(e);
	}
	@DeleteMapping(value="/{id}")
	public void deletePublication(@PathVariable Long id)
	{
		publicationService.deletePublication(id);
	}
	@PutMapping(value="/publication/{id}")
	public Publication updatePublication(@PathVariable Long id, @RequestBody Publication p)
	{
		p.setId(id);
		return publicationService.updatePublication(p);
	}

}
