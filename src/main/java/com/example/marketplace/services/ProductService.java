package com.example.marketplace.services;

import com.example.marketplace.models.Product;
import com.example.marketplace.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional()
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public void register(Product product) {
        productRepository.save(product);
    }

    public List<Product> userProducts(int id){
        return productRepository.userProducts(id);
    }

}
