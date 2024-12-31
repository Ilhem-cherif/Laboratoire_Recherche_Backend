package com.example.evenement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evenement.entities.Evenement;
import com.example.evenement.services.IEvenementService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/evenements")
public class EvenementController {
	private final IEvenementService evenementService;
	
	@GetMapping("/")
	public List<Evenement> findEvenement(){
		return evenementService.findAll();
	}
	@GetMapping(value="/{id}")
	public Evenement findOneEvenementById(@PathVariable Long id) {
		return evenementService.findEvenement(id);
	}
	@PostMapping(value="/evenement")
	public Evenement addEvenement(@RequestBody Evenement e)
	{
	return evenementService.addEvenement(e);
	}
	@DeleteMapping(value="/{id}")
	public void deleteEvenement(@PathVariable Long id)
	{
		evenementService.deleteEvenement(id);
	}
	@PutMapping(value="/evenement/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement e)
	{
		e.setId(id);
		return evenementService.updateEvenement(e);
	}
	

}
