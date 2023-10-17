package com.ayaz.blg.entities;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Post {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long postId;
	@Column(name ="post_title" , length = 100 , nullable = false)
	 private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne	 
	private User user;
	
	
	
	
	

}
