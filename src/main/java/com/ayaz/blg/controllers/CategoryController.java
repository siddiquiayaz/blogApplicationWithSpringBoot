package com.ayaz.blg.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayaz.blg.payloads.CategoryDto;
import com.ayaz.blg.payloads.ResponseHandler;
import com.ayaz.blg.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
      @PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory( @Valid @RequestBody CategoryDto categoryDto){
		 CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		 return new ResponseEntity<CategoryDto>(createCategory , HttpStatus.CREATED);
		
	}
      @GetMapping("/")
       public ResponseEntity<List<CategoryDto>> getAllCatgries(){
    	    List<CategoryDto> allCategries = this.categoryService.getAllCategoris();
    	    return ResponseEntity.ok(allCategries);
      }
      
      @GetMapping("/{categoryId}")
       public ResponseEntity<CategoryDto> getCategriesById( @PathVariable Long categoryId){
    	   CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
    	   return ResponseEntity.ok(categoryDto);
    	  
       }
      
      @PutMapping("/")
      public ResponseEntity<CategoryDto> updateCategory( @Valid @RequestBody CategoryDto  categoryDto ){
    	  CategoryDto updateCategory = categoryService.updateCotegory(categoryDto );
		return ResponseEntity.ok(updateCategory);
    	  
      }
        @DeleteMapping("/{categoryId}")
        public ResponseEntity<ResponseHandler> deleteCategory( @PathVariable Long categoryId){
        	categoryService.deleteCategory(categoryId);
        	return  ResponseEntity.ok(new  ResponseHandler("category deleted succsessfully", true));
        }
      
       
	
}
