package com.ayaz.blg.service;

import java.util.List;

import com.ayaz.blg.entities.Post;
import com.ayaz.blg.payloads.PostDto;


public interface PostService {
	PostDto createPost(PostDto postDto , Long userId ,Long catrgoryId);
	PostDto updatePost(PostDto postDto , Long postId);
    void  deletePost(Long  postId);
    List<PostDto> getAllPost();
    PostDto getPostById(Long postId);
    List<PostDto> getPostByCategory(Long catrgoryId);
    List<PostDto> getPostByUser(Long userId);
}
