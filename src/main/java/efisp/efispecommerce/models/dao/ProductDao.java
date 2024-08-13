package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.entitys.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductDao implements Dao<Product>{

    private static ProductDao instance;
    private final List<Product> products;

    private ProductDao() {
        products = new LinkedList<>();
    }

    public static Dao<Product> getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    @Override
    public boolean add(Product product) {
        Product product1 = new Product(product.getId(), product.getName(), product.getPrice(), product.getBrand(), product.getDescription(), product.getDepartment());
        return products.add(product1);
    }

    @Override
    public boolean update(long id, Product product) {
        Product product1 = new Product(product.getId(), product.getName(), product.getPrice(), product.getBrand(), product.getDescription(), product.getDepartment());

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product1);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(long id) {
        return products.remove((int) id) != null;
    }

    @Override
    public Product getById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return new Product(product.getId(), product.getName(), product.getPrice(), product.getBrand(), product.getDescription(), product.getDepartment());
            }
        }

        throw new RuntimeException("Product not found");
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    }


}
