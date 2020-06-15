package com.onlineshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
