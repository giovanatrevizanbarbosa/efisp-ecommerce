package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Product;

import java.util.List;
import java.util.UUID;

public class ProductService {
    private final BrandService brandService = new BrandService();
    private final DepartmentService departmentService = new DepartmentService();
    private final IDao<Product> dao = Dao.getInstance(Product.class);

    protected Product toEntity(ProductDTO productDTO){
        Brand brand = brandService.getByName(productDTO.brand());
        Department department = departmentService.getDepartmentByName(productDTO.department());

        return new Product(productDTO.id(), productDTO.name(), productDTO.price()
                ,brand, productDTO.description(), department, productDTO.stock());
    }

    protected ProductDTO toDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getPrice()
                , product.getBrand().getName(), product.getDescription(), product.getDepartment().getName(), product.getStock());
    }

    public List<Product> getAll() {
        return dao.getAll();
    }

    public boolean add(ProductDTO productDto) {
        return dao.add(toEntity(productDto));
    }

    public boolean update(UUID id, ProductDTO productDto) {
        return dao.update(id, toEntity(productDto));
    }

    public boolean delete(UUID id) {
        return dao.delete(id);
    }

    public ProductDTO getById(UUID id) {
        return toDTO(dao.getById(id));
    }
}
