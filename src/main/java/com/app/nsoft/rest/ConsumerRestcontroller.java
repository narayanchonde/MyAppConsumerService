package com.app.nsoft.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.nsoft.entity.Consumer;
import com.app.nsoft.exception.ConsumerNotFoundException;
import com.app.nsoft.service.IConsumerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/consumer")
@CrossOrigin("http://localhost:4200")
public class ConsumerRestcontroller {

	@Autowired
	private IConsumerService service;

	//1 Fetch all  consumer 
	@GetMapping("/all")
	public ResponseEntity<List<Consumer>> getAllConsumer(){
		log.info("Entered into getAllconsumer ...");

		ResponseEntity<List<Consumer>> response=null;
		try {
			List<Consumer> list=service.getAllConsumer();
			response=ResponseEntity.ok(list);
			log.info("Fetch all Consumer Success ");

		} catch (ConsumerNotFoundException cnfe) {
			cnfe.printStackTrace();
			log.info("Fetch not Successfull");
			throw cnfe;
		}

		return response;
	}

	//2 Save One Consumer 
	@PostMapping("/create")
	public ResponseEntity<String> consumerOneSave(@RequestBody Consumer consumer ){

		ResponseEntity<String> response=null;
		try {
			Long id =service.saveOneConsumer(consumer);
			response=ResponseEntity.ok("Consumer Created with '"+id+"' id ");
		} catch (ConsumerNotFoundException cnfe) {

			cnfe.printStackTrace();
			log.info("Fetch not Successfull");
			throw cnfe;
		}
System.out.println();
		return response;
	}

	//3 Fetch One Consumer By Email 

	@GetMapping("/find/{conEmail}") 
	public ResponseEntity<Consumer> consumerFindByEmail(@PathVariable String conEmail){
		ResponseEntity<Consumer> response=null;
		try {

			Consumer consumer =service.consumerFindByEmail(conEmail);
			response=ResponseEntity.ok(consumer);
		}catch (ConsumerNotFoundException e) {
			log.error(e.getMessage());
			throw e;	
		}
		return response; 
	}
	//4 fetch one Consumer by Pancard
	@GetMapping("/findpancard/{conPanCard}")
	public ResponseEntity<Consumer> consumerFindByPanCard(@PathVariable String conPanCard){
		ResponseEntity<Consumer> response=null;
		try {
			Consumer consumer =service.consumerFindByPanCard(conPanCard);
			response= ResponseEntity.ok(consumer);

		} catch (ConsumerNotFoundException e) {
			throw e ;
		}
		return response;
	}

	//5 Fetch one Consumer by AadharCard 
	@GetMapping("/findaadhar/{conAadhar}")
	public ResponseEntity<Consumer> getConsumerByAadhar(@PathVariable  String conAadhar){
		ResponseEntity<Consumer> response=null ;
		try {

			Consumer consumer=service.consumerFindByAadhar(conAadhar);
			response=ResponseEntity.ok(consumer);
		} catch (ConsumerNotFoundException e) {
			throw e;
		}

		return response ;
	}

	//6 Fetch one Consumer by Mobile Number 
	@GetMapping("/findmobile/{conMobile}")
	public ResponseEntity<Consumer> getConsumerByMobile(@PathVariable String conMobile){
		ResponseEntity<Consumer> response =null ;
		try {
			Consumer consumer =service.consumerFindByMobile(conMobile);
			response=ResponseEntity.ok(consumer);
		} catch (ConsumerNotFoundException e) {
			throw e;
		}
		return response ;
	}

	//8 Fetch One Consumer  by Id 
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Consumer> getConsumerById(@PathVariable Long id){
		ResponseEntity<Consumer> response=null;
		try {
			Consumer consumer=service.consumerFindById(id);
			response=ResponseEntity.ok(consumer);
		} catch (ConsumerNotFoundException e) {
			throw e;
		}
		return response;
	}

	//7 Delete one Consumer by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneConsumer(@PathVariable Long id){
		ResponseEntity<String> response=null;
		try {
			log.info("id came "+id.toString());
			service.consumerDeleteById(id);
			response=ResponseEntity.ok("Given '"+id+"' Data Deleted ");
		} catch (ConsumerNotFoundException e) {
			throw e;
		}

		return response;
	}


	//8 update One Consumer by id 
	@PostMapping("/update")
	public ResponseEntity<String> updateOneConsumer(@RequestBody Consumer  consumer){
		ResponseEntity<String> response=null;
		try {
			Long id =service.consumerOneUpdate(consumer);
			response=new ResponseEntity<String>("Consumer '"+id+"' data updated ",HttpStatus.OK);
		} catch (ConsumerNotFoundException e) {
			throw e;
		}
		return response ;
	}	
}
