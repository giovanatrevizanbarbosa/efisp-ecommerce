package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Product;

import java.util.List;

public class ProductService {
    private final BrandService brandService = new BrandService();
    private final DepartmentService departmentService = new DepartmentService();
    private final IDao<Product> dao = Dao.getInstance(Product.class);

    private Product mapProductDTOToEntity(ProductDTO productDTO){
        Brand brand = brandService.getBrandByName(productDTO.brand());
        Department department = departmentService.getDepartmentByName(productDTO.department());

        return new Product(productDTO.id(), productDTO.name(), productDTO.price()
                ,brand, productDTO.description(), department, productDTO.stock());
    }

    private ProductDTO mapProductEntityToDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getPrice()
                , product.getBrand().getName(), product.getDescription(), product.getDepartment().getName(), product.getStock());
    }

    public List<Product> getAll() {
        return dao.getAll();
    }

    public boolean add(ProductDTO productDto) {
        return dao.add(mapProductDTOToEntity(productDto));
    }

    public Long getNextId() {
        return dao.getNextId();
    }
}
