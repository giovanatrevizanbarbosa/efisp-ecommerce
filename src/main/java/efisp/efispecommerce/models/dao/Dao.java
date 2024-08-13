package efisp.efispecommerce.models.dao;

import java.util.List;

public interface Dao<T> {

    boolean add(T newValue);

    boolean update(long id, T newValue);

    boolean delete(long id);

    T getById(long id);

    List<T> getAll();
}
