package com.app.nsoft.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.nsoft.entity.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer	,Long> {

	
	Optional<Consumer> findByConEmail(String conEmail);
	Optional<Consumer> findByConPanCard(String conPancard);
	Optional<Consumer> findByConAadhar(String conAadhar);
	Optional<Consumer> findByConMobile(String conMobile);
	
	
	
}
