package com.example.marketplace.util;

import com.example.marketplace.models.Product;
import com.example.marketplace.services.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    private final ProductService productService;

    public ProductValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        boolean checkingNull = product.getName() == null;
        if(checkingNull){
            errors.reject("Fields must be filled "+ product.getName());
        }
    }

}
