package efisp.efispecommerce.models.dao.csv;

import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.entitys.*;
import efisp.efispecommerce.models.enums.PaymentMethod;

import java.util.List;
import java.util.UUID;

public class DomainConverter {

    public static Writable fromCsv(Csv csv, String clazzName){

        return switch (clazzName) {
            case "User" -> getUserFromCsv(csv);
            case "Administrator" -> getAdministratorFromCsv(csv);
            case "Title" -> getTitleFromCsv(csv);
            case "Address" -> getAddressFromCsv(csv);
            case "Brand" -> getBrandFromCsv(csv);
            case "Department" -> getDepartmentFromCsv(csv);
            case "Rating" -> getRatingFromCsv(csv);
            case "Item" -> getItemFromCsv(csv);
            case "Product" -> getProductFromCsv(csv);
            case "Cart" -> getCartFromCsv(csv);
            case "Order" -> getOrderFromCsv(csv);
            default -> null;
        };
    }

    private static User getUserFromCsv(Csv csv){
        String[] data = csv.getData();
        return new User(UUID.fromString(data[0]), data[1], data[2], data[3]);
    }

    private static Administrator getAdministratorFromCsv(Csv csv){
        IDao<Title> titleCsvReaderWriter = Dao.getInstance(Title.class);

        List<Title> titles = titleCsvReaderWriter.getAll();
        Title title = titles.stream().filter(t -> t.getId().equals(UUID.fromString(csv.getData()[4]))).findFirst().orElse(null);

        String[] data = csv.getData();
        return new Administrator(UUID.fromString(data[0]), data[1], data[2], data[3], title);
    }

    private static Title getTitleFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Title(UUID.fromString(data[0]), data[1], Integer.parseInt(data[2]));
    }

    public static Address getAddressFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Address(UUID.fromString(data[0]), data[1], Integer.parseInt(data[2]), data[3], data[4], data[5]);
    }

    public static Brand getBrandFromCsv(Csv csv){
        String[] data = csv.getData();

        return new Brand(UUID.fromString(data[0]),data[1]);
    }

    public static Department getDepartmentFromCsv(Csv csv){
        String[] data = csv.getData();

        return new Department(UUID.fromString(data[0]), data[1], data[2]);
    }

    public static Rating getRatingFromCsv(Csv csv){
        String[] data = csv.getData();

        return new Rating(UUID.fromString(data[0]), data[1], UUID.fromString(data[2]), data[3], Integer.parseInt(data[4]));
    }

    public static Item getItemFromCsv(Csv csv) {
        IDao<Product> csvReaderWriter = Dao.getInstance(Product.class);
        String[] data = csv.getData();

        Product product = csvReaderWriter.getAll().stream().filter(p -> p.getId().equals(UUID.fromString(data[2]))).findFirst().orElse(null);

        return new Item(UUID.fromString(data[0]), UUID.fromString(data[1]), product, Integer.parseInt(data[3]));
    }

    public static Product getProductFromCsv(Csv csv){
        IDao<Brand> brandCsvReaderWriter = Dao.getInstance(Brand.class);
        IDao<Department> departmentCsvReaderWriter = Dao.getInstance(Department.class);

        String[] data = csv.getData();

        List<Brand> brands = brandCsvReaderWriter.getAll();
        List<Department> departments = departmentCsvReaderWriter.getAll();


        Brand brand = brands.stream().filter(b -> b.getId().equals(UUID.fromString(data[3]))).findFirst().orElse(null);
        Department department = departments.stream().filter(d -> d.getId().equals(UUID.fromString(data[5]))).findFirst().orElse(null);

        return new Product(UUID.fromString(data[0]), data[1], Double.parseDouble(data[2]), brand, data[4], department, Integer.parseInt(data[6]));
    }

    public static Cart getCartFromCsv(Csv csv){
        String[] data = csv.getData();
        Cart cart = new Cart(UUID.fromString(data[0]), data[1]);

        List<Item> items = Dao.getInstance(Item.class).getAll();
        items.stream().filter(i -> i.getCartId().equals(cart.getId())).forEach(cart::insertItem);

        return cart;
    }

    public static Order getOrderFromCsv(Csv csv){
        IDao<User> userCsvReaderWriter = Dao.getInstance(User.class);
        IDao<Cart> cartCsvReaderWriter = Dao.getInstance(Cart.class);
        IDao<Address> addressCsvReaderWriter = Dao.getInstance(Address.class);

        String[] data = csv.getData();

        List<User> users = userCsvReaderWriter.getAll();
        List<Cart> carts = cartCsvReaderWriter.getAll();
        List<Address> addresses = addressCsvReaderWriter.getAll();

        User user = users.stream().filter(u -> u.getEmail().equals(data[1])).findFirst().orElse(null);
        Cart cart = carts.stream().filter(c -> c.getId().equals(UUID.fromString(data[2]))).findFirst().orElse(null);
        Address address = addresses.stream().filter(a -> a.getId().equals(UUID.fromString(data[4]))).findFirst().orElse(null);

        return new Order(UUID.fromString(data[0]), user, cart, PaymentMethod.valueOf(data[3]), address);
    }
}
