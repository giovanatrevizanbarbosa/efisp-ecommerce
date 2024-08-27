package efisp.efispecommerce.models.repository.csv;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.entitys.*;

import java.util.List;

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
            default -> null;
        };
    }

    private static User getUserFromCsv(Csv csv){
        String[] data = csv.getData();
        return new User(Integer.parseInt(data[0]), data[1], data[2], data[3]);
    }

    private static Administrator getAdministratorFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Administrator(Integer.parseInt(data[0]), data[1], data[2], data[3], new Title(data[4], Integer.parseInt(data[5])));
    }

    private static Title getTitleFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Title(data[1], Integer.parseInt(data[2]));
    }

    public static Address getAddressFromCsv(Csv csv){
        String[] data = csv.getData();
        var address = new Address(data[1], data[2], data[3], data[4], data[5]);
        address.setId(Long.parseLong(data[0]));

        return address;
    }

    public static Brand getBrandFromCsv(Csv csv){
        String[] data = csv.getData();
        var brand = new Brand(data[1]);
        brand.setId(Long.parseLong(data[0]));

        return brand;
    }

    public static Department getDepartmentFromCsv(Csv csv){
        String[] data = csv.getData();
        var department = new Department(data[1], data[2]);
        department.setId(Long.parseLong(data[0]));

        return department;
    }

    public static Rating getRatingFromCsv(Csv csv){
        String[] data = csv.getData();
        var rating = new Rating(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
        rating.setId(Long.parseLong(data[0]));

        return rating;
    }

    public static Item getItemFromCsv(Csv csv) {
        CsvReaderWriter<Product> csvReaderWriter = new CsvReaderWriter<>(Product.class.getSimpleName());

        List<Product> products = csvReaderWriter.read();

        String[] data = csv.getData();

        Product product = products.stream().filter(p -> p.getId() == Long.parseLong(data[2])).findFirst().orElse(null);

        return new Item(product, Integer.parseInt(data[3]));
    }

    public static Product getProductFromCsv(Csv csv){
        CsvReaderWriter<Brand> brandCsvReaderWriter = new CsvReaderWriter<>(Brand.class.getSimpleName());
        CsvReaderWriter<Department> departmentCsvReaderWriter = new CsvReaderWriter<>(Department.class.getSimpleName());

        List<Brand> brands = brandCsvReaderWriter.read();
        List<Department> departments = departmentCsvReaderWriter.read();

        String[] data = csv.getData();

        Brand brand = brands.stream().filter(b -> b.getId() == Long.parseLong(data[3])).findFirst().orElse(null);
        Department department = departments.stream().filter(d -> d.getId() == Long.parseLong(data[5])).findFirst().orElse(null);

        return new Product(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), brand, data[4], department, Integer.parseInt(data[6]));
    }

    public static Cart getCartFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Cart(Integer.parseInt(data[0]), data[1]);
    }
}
