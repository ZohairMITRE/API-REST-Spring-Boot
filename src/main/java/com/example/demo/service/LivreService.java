package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livre;
import com.example.demo.repo.LivreRepository;

@Service
public class LivreService {

	@Autowired
    LivreRepository repo;
	
	public List<Livre> getAllLivres(){
		return repo.findByOrderByTitreAsc();	
	}
	
	public Livre getLivre(Long id){	
		return repo.findById(id).get();
        
	}
	
	public Livre createLivre(Livre livre) {
		
		return repo.save(livre);
	}
	
	public Livre updateLivre( Livre livre , Long id) {
		Livre livreExistant = repo.findById(id).orElseThrow();
		
		livreExistant.setAuteur(livre.getAuteur()!=null ?livre.getAuteur() : livreExistant.getAuteur());
		livreExistant.setDisponible(livre.getDisponible()!= null ?livre.getDisponible() : livreExistant.getDisponible());
		livreExistant.setNbrpages(livre.getNbrpages()!=null ?livre.getNbrpages() : livreExistant.getNbrpages());
		livreExistant.setTitre(livre.getTitre()!=null ?livre.getTitre() : livreExistant.getTitre());
		livreExistant.setDconsultation(new Date());
		livreExistant.setDsortie(livre.getDsortie()!=null ? livre.getDsortie(): livreExistant.getDsortie());
		return repo.save(livreExistant);
	}
	
	public void deleteLivre(Long id) {
		repo.deleteById(id);
	}
	
}
