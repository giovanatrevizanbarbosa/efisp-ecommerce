package efisp.efispecommerce.models.repository;

import efisp.efispecommerce.models.repository.csv.Csv;

public abstract class Writable implements Comparable<Writable>{
    Long id;

    public Writable(Long id){
        this.id = id;
    }

    public abstract Csv toCSV();

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
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
