package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.entitys.Product;

import java.util.*;

public class ProductDao implements Dao<Product>{

    private static ProductDao instance;
    private final Map<Long, Product> products;

    private ProductDao() {
        products = new HashMap<>();
    }

    public static Dao<Product> getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    @Override
    public boolean add(Product product) {
        Product product1 = new Product(product.getId(), product.getName(), product.getPrice(), product.getBrand(), product.getDescription(), product.getDepartment(), 2);
        return products.put((long) product.getId(), product1) == null;
    }

    @Override
    public boolean update(long id, Product product) {
        Product product1 = new Product(product.getId(), product.getName(), product.getPrice(), product.getBrand(), product.getDescription(), product.getDepartment(), 2);
        return products.replace(id, product1) != null;
    }

    @Override
    public boolean delete(long id) {
        return products.remove(id) != null;
    }

    @Override
    public Product getById(long id) {
        Product productFinded = products.get(id);

        if (productFinded != null) {
            return new Product(productFinded.getId(), productFinded.getName(), productFinded.getPrice(), productFinded.getBrand(), productFinded.getDescription(), productFinded.getDepartment(), 2);
        }

        throw new RuntimeException("Product not found");
    }

    @Override
    public List<Product> getAll() {
        List<Product> productsList = new LinkedList<>();
        products.values().forEach(product -> productsList.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getBrand(), product.getDescription(), product.getDepartment(), 2)));
        return productsList;
    }


}
