package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entities.Owner;
import com.repositories.OwnerRepository;
import com.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {

	private final OwnerRepository ownerRepository;

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner save(Owner o) {
		Owner owner = ownerRepository.save(o);
		return owner;
	}

	@Override
	public List<Owner> getAllOwners() {
		List<Owner> all = ownerRepository.findAll();
		return all;
	}

	@Override
	public Optional<Owner> getOwnerById(int ownerId) {
		return Optional.empty();
	}

	@Override
	public void deleteOwnerById(int ownerId) {

	}

}
