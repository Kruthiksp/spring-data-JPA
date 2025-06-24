package com.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.OwnerDTO;
import com.entities.Owner;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OwnerMapper {
	OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);
	
	@Mapping(source = "productDTO", target = "product")		//This is added because the field names in DTO class and Entity class are different.
	@Mapping(target = "ownerId", ignore = true)
	Owner toEntity(OwnerDTO ownerDTO);
}
