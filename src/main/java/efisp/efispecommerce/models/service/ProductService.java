package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.BrandDTO;
import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ProductService {
    private final BrandService brandService = new BrandService();
    private final DepartmentService departmentService = new DepartmentService();
    private final IDao<Product> dao = Dao.getInstance(Product.class);

    protected Product toEntity(ProductDTO productDTO){
        Brand brand = brandService.getByName(productDTO.brand());
        Department department = departmentService.toEntity(departmentService.getDepartmentByName(productDTO.department()));

        return new Product(productDTO.id(), productDTO.name(), productDTO.price()
                ,brand, productDTO.description(), department, productDTO.stock(), productDTO.photo());
    }

    protected ProductDTO toDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getPrice()
                , product.getBrand().getName(), product.getDescription(), product.getDepartment().getName(), product.getStock(), product.getPhoto());
    }

    public List<ProductDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
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

    public List<ProductDTO> getByBrand(String brand) {
        for (BrandDTO b : brandService.getAll()) {
            if (b.name().equals(brand)) {
                return dao.getAll().stream().filter(p -> p.getBrand().getName().equals(brand)).map(this::toDTO).toList();
            }
        }

        return new LinkedList<>();
    }

    public List<ProductDTO> getByDepartment(String department) {
        for (DepartmentDTO d : departmentService.getAll()) {
            if (d.name().equals(department)) {
                return dao.getAll().stream().filter(p -> p.getDepartment().getName().equals(department)).map(this::toDTO).toList();
            }
        }

        return new LinkedList<>();
    }

    public List<ProductDTO> getByPriceRange(double min, double max) {
        return dao.getAll().stream().filter(p -> p.getPrice() >= min && p.getPrice() <= max).map(this::toDTO).toList();
    }

    public List<ProductDTO> getByStock(int stock) {
        return dao.getAll().stream().filter(p -> p.getStock() >= stock).map(this::toDTO).toList();
    }

    public List<ProductDTO> getByName(String name) {
        return dao.getAll().stream().filter(p -> p.getName().contains(name)).map(this::toDTO).toList();
    }
}
