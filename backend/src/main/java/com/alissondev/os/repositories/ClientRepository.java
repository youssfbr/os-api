package com.alissondev.os.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissondev.os.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByName(String name);
	List<Client> findByNameContaining(String name);
	Client findByEmail(String email);
}
