package com.ayaz.blg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayaz.blg.entities.Category;
import com.ayaz.blg.entities.Post;
import com.ayaz.blg.entities.User;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	 List<Post> findByCategory(Category category);
	 List<Post> findByUser(User user);

}
