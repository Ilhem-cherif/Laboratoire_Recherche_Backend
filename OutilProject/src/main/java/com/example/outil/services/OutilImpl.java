package com.example.outil.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.outil.dao.OutilRepository;
import com.example.outil.entities.Outil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OutilImpl implements IOutilService {

	private final OutilRepository outilRepository;
	@Override
	public Outil addOutil(Outil o) {
		return outilRepository.save(o);
	}

	@Override
	public void deleteOutil(Long id) {
		outilRepository.deleteById(id);

	}

	@Override
	public Outil updateOutil(Outil o) {
		
		return outilRepository.saveAndFlush(o);
	}

	@Override
	public Outil findOutil(Long id) {
		Outil o = outilRepository.findById(id).get();
		return o;
	}

	@Override
	public List<Outil> findAll() {
		return outilRepository.findAll();
	}

}
