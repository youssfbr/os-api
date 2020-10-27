package com.alissondev.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissondev.os.entities.Client;
import com.alissondev.os.repositories.ClientRepository;
import com.alissondev.os.services.exceptions.EmailExistException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public Client save(Client client) {
		Client clientExist = repository.findByEmail(client.getEmail());
		
		if (clientExist != null &&  !clientExist.equals(client)) {
			throw new EmailExistException("Já existe um cliente cadastrado com este e-mail.");
		}
		return repository.save(client);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public List<Client> findAll() {		
		return repository.findAll();
	}

	public Optional<Client> findById(Long id) {		
		return repository.findById(id);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}
	
	
}
