package com.onlineshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.Repository.ProductRepo;
import com.onlineshop.entity.Product;
import com.onlineshop.exception.ItemNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	public Product getProductById(long id) throws Exception {
		Optional<Product> product = productRepo.findById(id);
		if (product.isEmpty())
			throw new ItemNotFoundException("Record Not found for product id " + id);
		return product.get();
	}

	public Product saveOrUpdateProduct(Product product) {
		Optional<Product> productOpt = productRepo.findById(product.getId());
		if (productOpt.isPresent()) {
			Product newProduct = productOpt.get();
			newProduct.setBrand(product.getBrand());
			newProduct.setCategory(product.getCategory());
			newProduct.setDescription(product.getDescription());
			newProduct.setIsActive(product.getIsActive());
			newProduct.setName(product.getName());
			newProduct.setPurchases(product.getPurchases());
			newProduct.setQuantity(product.getQuantity());
			newProduct.setUnitPrice(product.getUnitPrice());
			newProduct.setUserDetails(product.getUserDetails());
			newProduct.setViews(product.getViews());
			return productRepo.save(newProduct);
		} else {
			product.setIsActive((byte) 1);
			return productRepo.save(product);
		}
	}

	public void deleteProduct(Product product) throws Exception {
		Optional<Product> productOpt = productRepo.findById(product.getId());
		if (productOpt.isPresent()) {
			Product newProduct = productOpt.get();
			newProduct.setIsActive((byte) 0);
			productRepo.save(newProduct);
		} else {
			throw new ItemNotFoundException("Record Not found for product id " + product.getId());
		}
	}

	public List<Product> listActiveProduct() {
		return productRepo.findByIsActive((byte) 1);
	}

	public List<Product> listActiveProductByCategory(long categoryId) {
		return productRepo.findActiveProductByCategory((byte) 1, categoryId);
	}

}
