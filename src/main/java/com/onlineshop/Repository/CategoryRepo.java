package com.onlineshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
