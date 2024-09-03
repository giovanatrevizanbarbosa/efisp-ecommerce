package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.dao.csv.CsvReaderWriter;

import java.util.*;


public class Dao<T extends Writable> implements IDao<T> {


    private final CsvReaderWriter<T> dataService;
    private static final Map<Class<?>, Dao<?>> instances = new HashMap<>();
    private final Set<Writable> data;
    private Long nextId = 1L;

    private Dao(Class<T> clazz) {
        dataService = new CsvReaderWriter<>(clazz.getSimpleName());
        try{
            data = new TreeSet<>(dataService.read());
            if (!data.isEmpty()) {
                nextId = data.stream().max(Comparator.comparing(Writable::getId)).get().getId() + 1;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e + " - Repository not created and file possibly is in use");
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
    public T getById(long id) {
        return (T) data.stream().filter(writable -> writable.getId() == id).findFirst().orElse(null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) List.copyOf(data);
    }

    @Override
    public Long getNextId() {
        return nextId++;
    }
}
