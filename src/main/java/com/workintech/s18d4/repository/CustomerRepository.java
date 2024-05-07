package com.workintech.s18d4.repository;

import com.workintech.s18d4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//1.Entity,2.Entity'nin Pk tipi.
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
