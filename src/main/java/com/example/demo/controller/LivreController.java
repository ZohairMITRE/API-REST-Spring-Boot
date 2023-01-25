package com.example.demo.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;


@RestController
@RequestMapping("/zohair_api/livres")
public class LivreController {
    @Autowired
    LivreService Service;
	
	@GetMapping
	public List<Livre> getAllLivres(){
		return Service.getAllLivres();	
	}
	
	@GetMapping("/{id}")
	public Livre getLivre(@PathVariable long id){
		return Service.getLivre(id);	
	}
	
	@PostMapping("/create")
	public Livre createLivre(@RequestBody Livre livre) {
		
		return Service.createLivre(livre);
	}
	@PutMapping("/update/{id}")
	public void updateLivre(@RequestBody Livre livre ,@PathVariable("id") Long id) {

		Service.updateLivre(livre , id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteLivre(@PathVariable("id") Long id) {
		Service.deleteLivre(id);
	}


}
