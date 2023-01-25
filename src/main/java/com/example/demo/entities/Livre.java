package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Livres")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@Column(length = 50 ,nullable=false)
	private String titre;
	@Column(nullable=false , updatable = false)
	private String maison;
	@Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Date dsortie;
	@Column(nullable=false)
	private String auteur;
	@Column(nullable=false)
	private String nbrpages;
	@Column(nullable=false)
	private Boolean disponible ;
	@Column(unique=true ,nullable=false ,updatable = false)
	private long ISBN;
	@Temporal(TemporalType.TIMESTAMP) @CreationTimestamp @Column(nullable = false)
	private Date dconsultation;
}
