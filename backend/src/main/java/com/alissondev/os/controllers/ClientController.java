package com.alissondev.os.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.os.entities.Client;
import com.alissondev.os.repositories.ClientRepository;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@GetMapping
	public  List<Client> findAll() {
		return repository.findAll();
	}
}
