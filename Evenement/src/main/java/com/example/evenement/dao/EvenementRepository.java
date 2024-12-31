package com.example.evenement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.evenement.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
