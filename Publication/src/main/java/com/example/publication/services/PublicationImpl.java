package com.example.publication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.publication.dao.PublicationRepository;
import com.example.publication.entities.Publication;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicationImpl implements IPublicationService {
	private final PublicationRepository pubRepository;

	@Override
	public Publication addPublication(Publication p) {
		return pubRepository.save(p);
	}

	@Override
	public void deletePublication(Long id) {
		pubRepository.deleteById(id);

	}

	@Override
	public Publication updatePublication(Publication p) {
		return pubRepository.saveAndFlush(p);
	}

	@Override
	public Publication findPublication(Long id) {
		Publication p = pubRepository.findById(id).get();
		return p;
	}

	@Override
	public List<Publication> findAll() {
		return pubRepository.findAll();
	}

}
