package com.ayaz.blg.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ayaz.blg.entities.Category;
import com.ayaz.blg.exceptions.ResourceNotFoundException;
import com.ayaz.blg.payloads.CategoryDto;
import com.ayaz.blg.repository.CategoryRespsitory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRespsitory categoryRespsitory;
	private final ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
            
		return modelMapper.map(categoryRespsitory.save(modelMapper.map(categoryDto
				
				, Category.class)), CategoryDto.class);
				
				          

	}

	@Override
	public CategoryDto updateCotegory(CategoryDto categoryDto) {
		     
           Category category =categoryRespsitory.findById(categoryDto.getCategoryId())
        		    
        		   
    .orElseThrow(() -> new ResourceNotFoundException("Category" , "Category Id" , categoryDto.getCategoryId()));
		        		    
           
		    return modelMapper.map(categoryRespsitory.save( modelMapper.map(category,
		        		
		        		   Category.class)), CategoryDto.class);
	}
            
	@Override
	public CategoryDto getCategoryById(Long categoryId) {
		
		   Category category = categoryRespsitory.findById(categoryId)
				   
    .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));	
		   
		            return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategoris() {
		 List<Category> allCategories = categoryRespsitory.findAll();

		return  allCategories.stream().map(category -> modelMapper
				
				 .map(category, CategoryDto.class)).toList();
	}

	@Override
	public void deleteCategory(Long categoryId) {
	       
		          Category category = categoryRespsitory.findById(categoryId)
		        		  
     .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		          
		                  categoryRespsitory.delete(category);
	}

}
