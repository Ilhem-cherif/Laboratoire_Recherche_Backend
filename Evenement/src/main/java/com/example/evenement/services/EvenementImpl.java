package com.example.evenement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.evenement.dao.EvenementRepository;
import com.example.evenement.entities.Evenement;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EvenementImpl implements IEvenementService {
	private final EvenementRepository evenementRepository;

	@Override
	public Evenement addEvenement(Evenement e) {
		return evenementRepository.save(e);
	}

	@Override
	public void deleteEvenement(Long id) {
		evenementRepository.deleteById(id);
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		return evenementRepository.saveAndFlush(e);
	}

	@Override
	public Evenement findEvenement(Long id) {
		Evenement e = evenementRepository.findById(id).get();
		return e;
	}

	@Override
	public List<Evenement> findAll() {
		return evenementRepository.findAll();
	}

}
