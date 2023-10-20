package com.ayaz.blg.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.ayaz.blg.entities.Post;
import com.ayaz.blg.payloads.PostDto;
import com.ayaz.blg.payloads.ResponseHandler;
import com.ayaz.blg.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;
	
	@PostMapping("user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long userId,
			@PathVariable Long categoryId) {
           return new ResponseEntity<PostDto>(this.postService.createPost(postDto, userId, categoryId),HttpStatus.CREATED);
		
	}
	    @GetMapping("post/{postId}")
	    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId){
	    	
	    	return ResponseEntity.ok(this.postService.getPostById(postId));
	    	
	    }
	
	@GetMapping("user/{userId}/post")
	  public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Long userId ){
		
		   List<PostDto> getpostByUser = this.postService.getPostByUser(userId);
		   return ResponseEntity.ok(getpostByUser);
		
	}
	
	@GetMapping("category/{categoryId}/post")
       public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId ) {
		List<PostDto> postByCategory = this.postService.getPostByCategory(categoryId);
		return ResponseEntity.ok(postByCategory);
	}  
	
	@DeleteMapping("post/{postId}")
	 public ResponseEntity<ResponseHandler> deletePost(@PathVariable Long postId){
		this.deletePost(postId);
		return new ResponseEntity<>(new ResponseHandler("post deleted succsessfully", false), HttpStatus.OK);
	}
	
	@GetMapping("post/")
	  public ResponseEntity<List<PostDto>> getAllPost(){
		return ResponseEntity.ok(this.postService.getAllPost());
	}
	
	@PutMapping("post/{postId}")
	 public ResponseEntity<PostDto> updatePost(@PathVariable Long postId , @RequestBody PostDto postDto){
		
		return new ResponseEntity<>( this.postService.updatePost(postDto, postId) ,HttpStatus.ACCEPTED);
	}
	
}
