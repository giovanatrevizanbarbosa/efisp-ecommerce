package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.entitys.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductService {
    private final List<Product> products = new LinkedList<>();

    private Product mapProductDTOToEntity(ProductDTO productDTO){
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice()
                , productDTO.getBrand(), productDTO.getDescription(), productDTO.getDepartment(), productDTO.getStock());
    }

    public boolean addProduct(ProductDTO productDTO) {
        return products.add(mapProductDTOToEntity(productDTO));
    }
}
