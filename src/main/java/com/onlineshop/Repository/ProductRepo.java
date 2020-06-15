package com.onlineshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	
	List<Product> findByIsActive(byte b);

	@Query("select p from Product p where p.isActive=?1 and p.category.id=?2")
	List<Product> findActiveProductByCategory(byte b, long categoryId);
	
}
