package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.repository.csv.Csv;

public class Product extends Writable {
    //id as identifier allows multiple products with same name, but different price, brand and description.
    private final String name;
    private final double price;
    private final Brand brand;
    private final String description;
    private final Department department;
    private final int stock;

    public Product(Long id, String name, double price, Brand brand, String description, Department department, int stock) {
        super(id);
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.department = department;
        this.stock = stock;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
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

    @Override
    public Csv toCSV() {
        return new Csv(
            new String[]{"id", "name", "price", "brand", "description", "department", "stock"},
            new String[]{String.valueOf(getId()), name, String.valueOf(price), brand.getName(), description, department.getName(), String.valueOf(stock)}
        );
    }
}