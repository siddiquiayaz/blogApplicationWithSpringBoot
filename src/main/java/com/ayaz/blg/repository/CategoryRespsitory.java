package com.ayaz.blg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayaz.blg.entities.Category;

public interface CategoryRespsitory extends JpaRepository<Category, Long> {

}
