package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}
