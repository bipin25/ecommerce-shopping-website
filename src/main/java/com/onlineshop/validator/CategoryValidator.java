package com.onlineshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.onlineshop.entity.Category;

@Component
public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Category category  = (Category)target;
		if(category.getName()==null || category.getName().isEmpty()) {
			errors.rejectValue("name", null, "Catgory name Required");
			
		}
		if(category.getDescription()==null || category.getDescription().isEmpty()) {
			errors.rejectValue("description", null, "Catgory description Required");
			
		}
		return;
	}
}
