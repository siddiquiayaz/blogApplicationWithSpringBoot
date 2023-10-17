package com.ayaz.blg.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
	private Long categoryId;
	@NotBlank(message = "categoryTitle is blank")
	@Size(min =4 , message = "categoryTitle size is minimum 4")
	private String categoryTitle;
	@NotBlank(message = "categoryDiscription is blank")
	@Size(min =4 , message = "categoryDiscription size is minimum 4")
	private String categoryDescription;
	
	
	
}
