package com.alissondev.os.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.os.entities.ServiceOrder;
import com.alissondev.os.services.ServiceOrderService;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

	@Autowired
	private ServiceOrderService service;
	
	@GetMapping
	public List<ServiceOrder> findAll() {		
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServiceOrder> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceOrder insert(@Valid @RequestBody ServiceOrder order) {		
		return service.save(order);
	}
	
}
