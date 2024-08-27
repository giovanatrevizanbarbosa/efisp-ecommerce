package efisp.efispecommerce.models.repository;

import efisp.efispecommerce.models.repository.csv.CsvReaderWriter;

import java.util.List;


public class Repository<T> implements IRepository<T> {


    private final CsvReaderWriter<T> dataService;
    private final List<Writable> data;

    @SuppressWarnings("unchecked")
    public Repository(Class<T> clazz) {
        dataService = new CsvReaderWriter<>(clazz.getSimpleName());
        data = (List<Writable>) dataService.read();
    }


    @Override
    public boolean add(Writable newValue) {
        data.add(newValue);

        try {
            dataService.save(data);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean update(long id, Writable newValue) {
        data.removeIf(writable -> writable.getId() == id);
        data.add(newValue);

        try {
            dataService.save(data);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(long id) {
        data.removeIf(writable -> writable.getId() == id);

        try {
            dataService.save(data);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(long id) {
        return (T) data.stream().filter(writable -> writable.getId() == id).findFirst().orElse(null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) data;
    }
}
