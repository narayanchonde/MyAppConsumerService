package com.app.nsoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.nsoft.entity.Consumer;
import com.app.nsoft.exception.ConsumerNotFoundException;
import com.app.nsoft.repo.ConsumerRepository;
import com.app.nsoft.service.IConsumerService;


@Service 
public class ConsumerServiceImpl implements IConsumerService {

	@Autowired
	private ConsumerRepository repo;

	@Override
	public List<Consumer> getAllConsumer() {

		return repo.findAll();
	}

	@Override
	public Long save(Consumer consumer) {

		return repo.save(consumer).getId();
	}

	@Override
	public Long saveOneConsumer(Consumer consumer) {

		return repo.save(consumer).getId();
	}

	@Override
	public Consumer consumerFindByEmail(String conEmail) {
		Optional<Consumer> opt=repo.findByConEmail(conEmail);
		return  opt.orElseThrow(()->new ConsumerNotFoundException("Given Mail id Data Not Found..."));
	}

	@Override
	public Consumer consumerFindByPanCard(String conPanCard) {
		Optional<Consumer> opt=repo.findByConPanCard(conPanCard);

		return opt.orElseThrow(()-> new ConsumerNotFoundException("With Given PanCard Is no  Data Found ...") );
	}

	@Override
	public Consumer consumerFindByAadhar(String conAadhar) {
		Optional<Consumer> opt =repo.findByConAadhar(conAadhar);
		return opt.orElseThrow(()-> new ConsumerNotFoundException(" Wrong Aadhar id '"+conAadhar+"' Please Provide Right Aadhar"));
	}

	@Override
	public Consumer consumerFindByMobile(String conMobile) {
		Optional<Consumer> opt=repo.findByConMobile(conMobile);
		return opt.orElseThrow(()-> new ConsumerNotFoundException("Given Mobile  Number '"+conMobile+"' Data Not found "));
	}

	@Override
	public Consumer consumerFindById(Long id) {
		Optional<Consumer> opt=repo.findById(id);
		return opt.orElseThrow(
				()-> new ConsumerNotFoundException("Given Id '"+id +"' Data Not Found ..."));
	}

	@Override
	@Transactional
	public Long consumerOneUpdate(Consumer consumer) {
		
		System.out.println("@@@@@@");
		if(consumer.getId() != null) {
			repo.save(consumer);
			System.out.println("+++++++++");
			return consumer.getId();
		}else {
			throw new ConsumerNotFoundException(" Please Provide  Consumer  Id , Data  not Update");

		}
	}

	@Override
	@Transactional
	public void consumerDeleteById(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			System.out.println("***");
		}else {
			throw new ConsumerNotFoundException(" Given id not found");
				
		}

	}
}