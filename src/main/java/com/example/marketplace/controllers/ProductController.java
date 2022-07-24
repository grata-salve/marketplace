package com.example.marketplace.controllers;

import com.example.marketplace.dto.IdDto;
import com.example.marketplace.dto.ProductDTO;
import com.example.marketplace.dto.ProductResponse;
import com.example.marketplace.dto.UserDTO;
import com.example.marketplace.models.Product;
import com.example.marketplace.models.User;
import com.example.marketplace.services.ProductService;
import com.example.marketplace.util.ProductValidator;
import com.example.marketplace.util.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.stream.Collectors;

import static com.example.marketplace.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final ProductValidator productValidator;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper, ProductValidator productValidator) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.productValidator = productValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody @Valid ProductDTO productDTO,
                                                 BindingResult bindingResult) {
        Product productToAdd = convertToProduct(productDTO);
        productValidator.validate(productToAdd, bindingResult);

        if(bindingResult.hasErrors()){
            returnErrorsToClient(bindingResult);
        } else {
            System.out.println(productToAdd);
            productService.register(productToAdd);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ProductResponse getProducts() {
        return new ProductResponse(productService.findAll().stream().map(this::convertToProductDTO)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{id}")
   public void deleteUser(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/user_products/{id}")
    public ProductResponse userProducts(@PathVariable int id){
        return new ProductResponse(productService.userProducts(id).stream().map(this::convertToProductDTO)
                .collect(Collectors.toList()));
    }

    private Product convertToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    private ProductDTO convertToProductDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

}
