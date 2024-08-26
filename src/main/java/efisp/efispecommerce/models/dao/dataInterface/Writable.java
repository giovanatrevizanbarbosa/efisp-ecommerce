package efisp.efispecommerce.models.dao.dataInterface;

public interface Writable<T> {

    CSV toCSV();

    T fromCSV(CSV csv);
}
