package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {

	public List<Livre> findByOrderByTitreAsc();
}
