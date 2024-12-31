package com.example.publication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.publication.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
