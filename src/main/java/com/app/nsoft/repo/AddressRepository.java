package com.app.nsoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.nsoft.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
