package com.alissondev.os.services;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissondev.os.entities.Client;
import com.alissondev.os.entities.ServiceOrder;
import com.alissondev.os.entities.enums.StatusServiceOrder;
import com.alissondev.os.repositories.ClientRepository;
import com.alissondev.os.repositories.ServiceOrderRepository;
import com.alissondev.os.services.exceptions.BadRequestException;
import com.alissondev.os.services.exceptions.NotFoundException;

@Service
public class ServiceOrderService {
	
	@Autowired
	private ServiceOrderRepository repository;
	
	@Autowired 
	private ClientRepository clientRepository;
	
	public List<ServiceOrder> findAll() {
		return repository.findAll();
	}
	
	public ServiceOrder findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Ordem de Serviço não encontrada"));
	}
	
	public ServiceOrder save(ServiceOrder order) {
		
		Client client = clientRepository.findById(order.getClient().getId())
				.orElseThrow(() -> new BadRequestException("Cliente não encontrado")) ;
		
		order.setClient(client);
		order.setStatus(StatusServiceOrder.ABERTA);
		order.setOpenDate(OffsetDateTime.now());
		
		return repository.save(order);
	}
}
