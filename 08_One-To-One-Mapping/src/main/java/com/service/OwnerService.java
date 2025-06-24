package com.service;

import java.util.List;
import java.util.Optional;

import com.entities.Owner;

public interface OwnerService {
	Owner save(Owner o);

	List<Owner> getAllOwners();

	Optional<Owner> getOwnerById(int ownerId);
	
	void deleteOwnerById(int ownerId);
}
