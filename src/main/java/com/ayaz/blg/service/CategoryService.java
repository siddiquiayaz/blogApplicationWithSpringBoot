package com.ayaz.blg.service;

import java.util.List;

import com.ayaz.blg.payloads.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCotegory(CategoryDto categoryDto );
	
	CategoryDto getCategoryById(Long id);
	
	List<CategoryDto>  getAllCategoris();
	
	void deleteCategory(Long id);
	
	

}
