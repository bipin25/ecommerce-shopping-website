package com.onlineshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.onlineshop.entity.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product  = (Product)target;
		
		if(product.getFile()==null || 
				product.getFile().isEmpty()||
				product.getFile().getOriginalFilename().equals("")
				) {
			errors.rejectValue("file", null, "Plz select the file");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("image/jpeg")
			|| product.getFile().getContentType().equals("image/png")
			|| product.getFile().getContentType().equals("image/gif")
				)) {
			errors.rejectValue("file", null, "File type should be jpeg, png or gif");
			return ;
		}

	}

}
