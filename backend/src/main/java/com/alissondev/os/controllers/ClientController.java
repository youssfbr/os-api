package com.alissondev.os.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.os.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@GetMapping
	public  List<Client> busca() {
		var client1 = new Client();
		var client2 = new Client();
		
		client1.setId(1L);
		client1.setName("Alisson");
		client1.setEmail("youssfbr@gmail.com");
		client1.setTelephone("85999911122");
		
		client2.setId(2L);
		client2.setName("Link da Silva");
		client2.setEmail("link@gmail.com");
		client2.setTelephone("859459915821");
				
		return Arrays.asList(client1, client2);
	}
}
