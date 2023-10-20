package com.ayaz.blg.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ayaz.blg.entities.Category;
import com.ayaz.blg.entities.Post;
import com.ayaz.blg.entities.User;
import com.ayaz.blg.exceptions.ResourceNotFoundException;
import com.ayaz.blg.payloads.PostDto;
import com.ayaz.blg.repository.CategoryRespsitory;
import com.ayaz.blg.repository.PostRepository;
import com.ayaz.blg.repository.UserRepositroy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService{
	 private final PostRepository postRepository;
	 private final ModelMapper modelMapper;
	 private final UserRepositroy userRepositroy;
	 private final CategoryRespsitory categoryRespsitory;
   
    @Override
	public PostDto createPost(PostDto postDto , Long userId ,Long categoryId) {
		User user = this.userRepositroy.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		Category category = this.categoryRespsitory.findById(categoryId)
				   .orElseThrow( () ->new ResourceNotFoundException("Category", "categoryId", categoryId));
		         Post post =  this.modelMapper.map(postDto,Post.class ) ;
		
		         post.setAddedDate(new Date());
		         post.setUser(user);
		         post.setCategory(category);
		         
		        return this.modelMapper.map(this.postRepository.save(post), PostDto.class);
		         
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Long postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(() ->
	      new ResourceNotFoundException("Post", "postId", postId));
		   post.setAddedDate(new Date());
		return this.modelMapper.map(this.postRepository.save(this.modelMapper
				  .map(postDto, Post.class )), PostDto.class);
	}

	@Override
	public void deletePost(Long postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(() ->
		      new ResourceNotFoundException("Post", "postId", postId));
		  this.postRepository.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		 return this.postRepository.findAll()
		   .stream().map(m -> this.modelMapper
				   .map(m, PostDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public PostDto getPostById(Long postId) {
		 Post post = this.postRepository.findById(postId).orElseThrow(() ->
		   new ResourceNotFoundException("Post", "postId", postId));
		  return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Long catrgoryId) {
	            Category category  = this.categoryRespsitory.findById(catrgoryId).orElseThrow(() 
				-> new ResourceNotFoundException("Category", "categoryId", catrgoryId));
		   List<Post> postList =this.postRepository.findByCategory(category);
		   return postList.stream().map(post -> this.modelMapper.map(post, PostDto.class)).toList();
		   
	}

	@Override
	public List<PostDto> getPostByUser(Long userId) {
		User user  = this.userRepositroy.findById(userId).orElseThrow(() 
					-> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts =this.postRepository.findByUser(user);
		   return posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).toList();
	}

	

}
