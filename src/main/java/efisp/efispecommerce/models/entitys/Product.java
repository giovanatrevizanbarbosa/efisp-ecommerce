package efisp.efispecommerce.models.entitys;

public class Product {
    private final int id;
    //id as identifier allows multiple products with same name, but different price, brand and description.
    private final String name;
    private final double price;
    private final Brand brand;
    private final String description;
    private final Department department;

    public Product(int id, String name, double price, Brand brand, String description, Department department) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.department = department;
    }

    public int getId() {
        return id;
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
}