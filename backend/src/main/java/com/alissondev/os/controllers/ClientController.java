package com.alissondev.os.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Optional<Client> result = repository.findById(id);		
		
		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client insert(@Valid @RequestBody Client client) {
		return repository.save(client);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @Valid @RequestBody Client client) {
		
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		client = repository.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
