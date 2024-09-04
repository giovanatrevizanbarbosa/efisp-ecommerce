package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.dao.csv.CsvReaderWriter;

import java.util.*;


public class Dao<T extends Writable> implements IDao<T> {


    private final CsvReaderWriter<T> dataService;
    private static final Map<Class<?>, Dao<?>> instances = new HashMap<>();
    private final Set<Writable> data;

    private Dao(Class<T> clazz) {
        dataService = new CsvReaderWriter<>(clazz.getSimpleName());
        try{
            data = new LinkedHashSet<>(dataService.read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Writable> Dao<T> getInstance(Class<T> clazz) {
        if (!instances.containsKey(clazz)) {
            instances.put(clazz, new Dao<>(clazz));
            return (Dao<T>) instances.get(clazz);
        }

        return (Dao<T>) instances.get(clazz);
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
    public boolean update(UUID id, Writable newValue) {
        try {
            data.removeIf(writable -> writable.getId().equals(id));
            if (!data.add(newValue)) return false;
            dataService.save(List.copyOf(data));
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(UUID id) {
        try {
            data.removeIf(writable -> writable.getId().equals(id));
            dataService.save(List.copyOf(data));
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(UUID id) {
        return (T) data.stream().filter(writable -> writable.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) List.copyOf(data);
    }
}
