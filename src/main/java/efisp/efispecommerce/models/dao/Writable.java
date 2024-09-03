package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.UUID;

/**
 * Abstract class that represents a writable object.
 */
public abstract class Writable implements Comparable<Writable>{
    UUID id;

    public Writable(UUID id){
        this.id = id;
    }

    /**
     * Converts the object to a CSV object.
     * @return CSV object.
     */
    public abstract Csv toCSV();

    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Writable writable = (Writable) obj;
        return id.equals(writable.id);
    }

    @Override
    public int compareTo(Writable o) {
        if (o != null) {
            return id.compareTo(o.id);
        }

        return 0;
    }
}
