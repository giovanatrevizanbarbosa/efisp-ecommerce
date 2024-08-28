package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;

public class ProductDTO {
    private final Long id;
    private final String name;
    private final double price;
    private final Brand brand;
    private final String description;
    private final Department department;
    private final int stock;

    public ProductDTO(Long id, String name, double price, Brand brand, String description, Department department, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.department = department;
        if(stock < 0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }else{
            this.stock = stock;
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Department getDepartment() {
        return department;
    }

    public int getStock() {
        return stock;
    }

    public Brand getBrand() {
        return brand;
    }
}
