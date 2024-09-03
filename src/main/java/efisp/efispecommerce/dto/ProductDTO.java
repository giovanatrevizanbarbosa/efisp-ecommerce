package efisp.efispecommerce.dto;

import java.util.UUID;

/**
 * @param id Product's id
 * @param name Product's name
 * @param price Product's price
 * @param brand Product's brand
 * @param description Product's description
 * @param department Product's department
 * @param stock Product's stock
 */
public record ProductDTO(UUID id, String name, double price, String brand, String description, String department,
                         int stock) {

    public ProductDTO(UUID id, String name, double price, String brand, String description, String department, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.department = department;
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        } else {
            this.stock = stock;
        }
    }
}
