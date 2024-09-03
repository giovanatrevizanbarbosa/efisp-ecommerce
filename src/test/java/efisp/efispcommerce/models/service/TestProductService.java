package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.BrandDTO;
import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.service.BrandService;
import efisp.efispecommerce.models.service.DepartmentService;
import efisp.efispecommerce.models.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProductService {
    private static final ProductService productService = new ProductService();

    @BeforeAll
    public static void setUp() {

        BrandService brandService = new BrandService();
        BrandDTO brand = new BrandDTO(brandService.getNextId(), "Nvidia");
        brandService.add(brand);


        DepartmentService departmentService = new DepartmentService();
        DepartmentDTO department = new DepartmentDTO(departmentService.getNextId(), "Informática", "Informática");
        departmentService.add(department);


        ProductDTO productDTO = new ProductDTO(productService.getNextId(), "Teclado Mecânico", 600.00, brand.name()
                , "Teclado com teclas suaves", department.name(), 15);

        productService.add(productDTO);
    }

    @Test
    public void addProductReturnsBoolean() {
        boolean actual = productService.add(new ProductDTO(productService.getNextId(), "Mouse", 200.00, "Nvidia"
                , "Mouse com fio", "Informática", 10));

        assertTrue(actual);
    }

    @Test
    public void getAllProductsReturnsList() {
        // When
        int expected = productService.getAll().size() + 1;

        productService.add(new ProductDTO(productService.getNextId(), "Mouse", 200.00, "Nvidia"
                , "Mouse com fio", "Informática", 10));

        int actual = productService.getAll().size();


        // Then
        assertEquals(expected, actual);
    }
}
