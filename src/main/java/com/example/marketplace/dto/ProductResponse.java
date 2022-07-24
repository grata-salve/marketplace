package com.example.marketplace.dto;

import java.util.List;

public class ProductResponse {

    List<ProductDTO> productDTOS;

    public ProductResponse(List<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public List<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(List<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }
}
