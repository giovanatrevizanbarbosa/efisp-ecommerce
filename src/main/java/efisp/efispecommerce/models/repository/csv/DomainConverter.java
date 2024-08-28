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
        return new User(Long.parseLong(data[0]), data[1], data[2], data[3]);
    }

    private static Administrator getAdministratorFromCsv(Csv csv){
        CsvReaderWriter<Title> titleCsvReaderWriter = new CsvReaderWriter<>(Title.class.getSimpleName());
        List<Title> titles = titleCsvReaderWriter.read();

        Title title = titles.stream().filter(t -> t.getId() == Long.parseLong(csv.getData()[4])).findFirst().orElse(null);

        String[] data = csv.getData();
        return new Administrator(Long.parseLong(data[0]), data[1], data[2], data[3], title);
    }

    private static Title getTitleFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Title(Long.parseLong(data[0]), data[1], Integer.parseInt(data[2]));
    }

    public static Address getAddressFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Address(Long.parseLong(data[0]), data[1], Integer.parseInt(data[2]), data[3], data[4], data[5]);
    }

    public static Brand getBrandFromCsv(Csv csv){
        String[] data = csv.getData();

        return new Brand(Long.parseLong(data[0]),data[1]);
    }

    public static Department getDepartmentFromCsv(Csv csv){
        String[] data = csv.getData();

        return new Department(Long.parseLong(data[0]), data[1], data[2]);
    }

    public static Rating getRatingFromCsv(Csv csv){
        String[] data = csv.getData();

        return new Rating(Long.parseLong(data[0]), data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
    }

    public static Item getItemFromCsv(Csv csv) {
        CsvReaderWriter<Product> csvReaderWriter = new CsvReaderWriter<>(Product.class.getSimpleName());

        List<Product> products = csvReaderWriter.read();

        String[] data = csv.getData();

        Product product = products.stream().filter(p -> p.getId() == Long.parseLong(data[1])).findFirst().orElse(null);

        return new Item(Long.parseLong(data[0]), product, Integer.parseInt(data[2]));
    }

    public static Product getProductFromCsv(Csv csv){
        CsvReaderWriter<Brand> brandCsvReaderWriter = new CsvReaderWriter<>(Brand.class.getSimpleName());
        CsvReaderWriter<Department> departmentCsvReaderWriter = new CsvReaderWriter<>(Department.class.getSimpleName());

        List<Brand> brands = brandCsvReaderWriter.read();
        List<Department> departments = departmentCsvReaderWriter.read();

        String[] data = csv.getData();

        Brand brand = brands.stream().filter(b -> b.getId() == Long.parseLong(data[3])).findFirst().orElse(null);
        Department department = departments.stream().filter(d -> d.getId() == Long.parseLong(data[5])).findFirst().orElse(null);

        return new Product(Long.parseLong(data[0]), data[1], Double.parseDouble(data[2]), brand, data[4], department, Integer.parseInt(data[6]));
    }

    public static Cart getCartFromCsv(Csv csv){
        String[] data = csv.getData();
        return new Cart(Long.parseLong(data[0]), data[1]);
    }
}
