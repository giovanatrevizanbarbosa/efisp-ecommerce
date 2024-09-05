package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.dto.*;
import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestCartController {
    static CartController controller;
    static CartDTO cartDto;

    @BeforeAll
    public static void Initialize() {
        var items = new HashMap<UUID, Item>();
        var user = new UserService();
        user.addUser(new UserDTO(UUID.randomUUID(), "Gi", "gi.fiasdfasdasf.com", "123"));
        cartDto = new CartDTO(UUID.randomUUID(), "gi.fiasdfasdasf.com", items);
        controller = new CartController();
        controller.addCart(cartDto);
    }

    @Test
    public void testAddCart() {
        var user = new UserService();
        var ownerEmail = "testCartControolerEMai.com";
        user.addUser(new UserDTO(UUID.randomUUID(), "Gi", ownerEmail, "123"));
        var items = new HashMap<UUID, Item>();

        CartDTO cartDto = new CartDTO(UUID.randomUUID(), ownerEmail, items);

        var result = controller.addCart(cartDto);

        assertTrue(result);
    }

    @Test
    public void testGetCartByOwnerEmail(){
        var user = new UserService();
        var ownerEmail = "testCartControolerEMai2.com";

        CartDTO cartDto = new CartDTO(UUID.randomUUID(), ownerEmail, new HashMap<>());
        controller.addCart(cartDto);

        user.addUser(new UserDTO(UUID.randomUUID(), "Gi", ownerEmail, "123"));
        var result = controller.getCartByOwnerEmail(ownerEmail);

        assertEquals(cartDto, result);
    }

    @Test
    public void addItemToCart() {
        ProductService productService = new ProductService();
        BrandService brandService = new BrandService();
        DepartmentService departmentService = new DepartmentService();
        UserService userService = new UserService();

        DepartmentDTO departmentDto = new DepartmentDTO(UUID.randomUUID(), "Department", "Description");
        departmentService.add(departmentDto);

        BrandDTO brandDto = new BrandDTO(UUID.randomUUID(), "Brand");
        brandService.add(brandDto);

        var userDto = new UserDTO(UUID.randomUUID(), "Gi", "gi.fiasdfasdaasdsf.com", "123");
        userService.addUser(userDto);

        CartDTO cartDto = new CartDTO(UUID.randomUUID(), "gi.fiasdfasdaasdsf.com", new HashMap<>());
        controller.addCart(cartDto);

        var productDto = new ProductDTO(UUID.randomUUID(), "Product", 10.0, brandDto.name(),"Produtin top dms" , departmentDto.name(), 10, "image");
        productService.add(productDto);

        var itemDto = new ItemDTO(UUID.randomUUID(), productDto, cartDto.id(), 1);

        var result = controller.addItemToCart(itemDto);
        assertTrue(result);

        var cart = controller.getCartById(cartDto.id());

        assertTrue(cart.items().containsKey(itemDto.id()));
    }
}