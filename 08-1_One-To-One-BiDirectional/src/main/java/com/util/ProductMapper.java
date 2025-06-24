package com.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.ProductDTO;
import com.entities.Product;

@Mapper(componentModel = "spring",uses = OwnerMapper.class) // this annotation will register the interface as bean
public interface ProductMapper {
	ProductMapper INSTANCE  = Mappers.getMapper(ProductMapper.class);

	@Mapping(target = "productId", ignore = true)
	@Mapping(source = "ownerDTO", target = "owner")
	Product toEntity(ProductDTO dto);
	
	@Mapping(source = "owner", target = "ownerDTO")
	ProductDTO toDTO(Product entity);
}