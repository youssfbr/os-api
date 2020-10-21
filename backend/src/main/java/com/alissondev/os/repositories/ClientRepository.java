package com.alissondev.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissondev.os.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
