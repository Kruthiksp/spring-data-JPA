package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {
	private Integer ownerId;
	private String name;
	private String email;
	private ProductDTO productDTO;
}
