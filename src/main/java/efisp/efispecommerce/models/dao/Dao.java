package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.dao.csv.CsvReaderWriter;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Dao<T extends Writable> implements IDao<T> {


    private final CsvReaderWriter<T> dataService;
    private final Set<Writable> data;

    public Dao(Class<T> clazz) {
        dataService = new CsvReaderWriter<>(clazz.getSimpleName());
        try{
            data = new TreeSet<>(dataService.read());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e + " - Repository not created and file possibly is in use");
        }
    }


    @Override
    public boolean add(Writable newValue) {
        try {
            if (!data.add(newValue)) return false;
            dataService.save(List.copyOf(data));
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(long id, Writable newValue) {
        try {
            data.removeIf(writable -> writable.getId() == id);
            if (!data.add(newValue)) return false;
            dataService.save(List.copyOf(data));
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            data.removeIf(writable -> writable.getId() == id);
            dataService.save(List.copyOf(data));
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(long id) {
        return (T) data.stream().filter(writable -> writable.getId() == id).findFirst().orElse(null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) List.copyOf(data);
    }
}
