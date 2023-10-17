package com.ayaz.blg.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String email;
     private String password;
     private String about;
     
     @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
     private List<Post> posts =new ArrayList<>();
    
	
}
