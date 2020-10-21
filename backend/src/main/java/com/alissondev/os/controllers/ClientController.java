package com.alissondev.os.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.os.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping
	public  List<Client> findAll() {
		return manager.createQuery("from Client", Client.class)
				.getResultList();
	}
}
