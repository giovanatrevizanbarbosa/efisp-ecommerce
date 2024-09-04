package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.service.ProductService;

import java.util.List;
import java.util.UUID;

public class ProductController {
    private final ProductService service;
    private final AdmController admController;

    public ProductController() {
        admController = new AdmController();
        service = new ProductService();
    }

    public boolean add(ProductDTO productDto, AdmDTO admDto) {
        if (admController.authenticate(admDto.email(), admDto.password()) == null) return false;
        return service.add(productDto);
    }

    public boolean update(UUID id, ProductDTO productDto, AdmDTO admDto) {
        if (admController.authenticate(admDto.email(), admDto.password()) == null) return false;
        return service.update(id, productDto);
    }

    public boolean delete(UUID id, AdmDTO admDto) {
        if (admController.authenticate(admDto.email(), admDto.password()) == null) return false;
        return service.delete(id);
    }

    public ProductDTO get(UUID id) {
        return service.getById(id);
    }

    public List<ProductDTO> getAll() {
        return service.getAll();
    }

    public List<ProductDTO> getByBrand(String brand) {
        return service.getByBrand(brand);
    }

    public List<ProductDTO> getByDepartment(String department) {
        return service.getByDepartment(department);
    }

    public List<ProductDTO> getByPriceRange(double min, double max) {
        return service.getByPriceRange(min, max);
    }

    public List<ProductDTO> getByStock(int stock) {
        return service.getByStock(stock);
    }

    public List<ProductDTO> getByName(String name) {
        return service.getByName(name);
    }

}
