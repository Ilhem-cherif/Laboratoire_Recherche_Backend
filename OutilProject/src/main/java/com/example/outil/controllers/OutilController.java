package com.example.outil.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.outil.entities.Outil;
import com.example.outil.services.IOutilService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/outils")
public class OutilController {
	
	private final IOutilService outilService;
	
	@GetMapping(value="/")
	public List<Outil> findOutils(){
		return outilService.findAll();
	}
	@GetMapping(value="/{id}")
	public Outil findOneOutilById(@PathVariable Long id) {
		return outilService.findOutil(id);
	}
	@PostMapping(value="/outil")
	public Outil addOutil(@RequestBody Outil o)
	{
	return outilService.addOutil(o);
	}
	@DeleteMapping(value="/{id}")
	public void deleteOutil(@PathVariable Long id)
	{
		outilService.deleteOutil(id);
	}
	@PutMapping(value="/outil/{id}")
	public Outil updateOutil(@PathVariable Long id, @RequestBody Outil o)
	{
		o.setId(id);
		return outilService.updateOutil(o);
	}

}
