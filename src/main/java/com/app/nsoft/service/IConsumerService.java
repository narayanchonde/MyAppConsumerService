package com.app.nsoft.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.nsoft.entity.Consumer;

public interface IConsumerService {
	
	List<Consumer> getAllConsumer();
	
	Long save(Consumer consumer);

	Long saveOneConsumer(Consumer consumer);

	Consumer consumerFindByEmail(String conEmail);

	Consumer consumerFindByPanCard(String conPanCard);

	Consumer consumerFindByAadhar(String conAadhar);

	Consumer consumerFindByMobile(String conMobile);

	Consumer consumerFindById(Long id);

	Long consumerOneUpdate(Consumer consumer);

	void consumerDeleteById(Long id); 
	
}
