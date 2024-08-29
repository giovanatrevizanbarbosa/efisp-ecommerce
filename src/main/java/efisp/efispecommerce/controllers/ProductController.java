package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.service.ProductService;

public class ProductController {
    private ProductService service;

    public ProductController() {
        service = new ProductService();
    }

    public boolean addProduct(ProductDTO productDto) {
        return service.addProduct(productDto);
    }
}
