package com.onlineshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.Repository.CategoryRepo;
import com.onlineshop.entity.Category;

@Service
public class Categoryservice {

	@Autowired
	CategoryRepo categoryRepo;
	
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	
	public Category getCategoryById(long id) throws Exception {
		Optional<Category> category =  categoryRepo.findById(id);
		if(category.isEmpty())
			throw new Exception("Record not found categoryId: "+id);
		return category.get();
	}
	
	public Category saveorUpdateCategory(Category category) {
		Optional<Category> cat =  categoryRepo.findById(category.getId());
		if(cat.isPresent()) {
			Category newCategory = cat.get();
			newCategory.setDescription(category.getDescription());
			newCategory.setImageUrl(category.getImageUrl());
			newCategory.setIsActive(category.getIsActive());
			newCategory.setName(category.getName());
			return categoryRepo.save(newCategory);
		}else {
			category.setIsActive((byte) 1);
			return categoryRepo.save(category);
		}
	}
	
	public void deleteCategory(Category category) throws Exception {
		Optional<Category> cat = categoryRepo.findById(category.getId());
		if(cat.isPresent()) {
			category.setIsActive((byte) 0);
			categoryRepo.save(category);		
		}else {
			throw new Exception("Record not found CateogoryID:"+category.getId());
		}
	
	}
	
}
