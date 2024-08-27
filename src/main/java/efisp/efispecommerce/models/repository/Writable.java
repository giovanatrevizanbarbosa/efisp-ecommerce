package efisp.efispecommerce.models.repository;

import efisp.efispecommerce.models.repository.csv.Csv;

public abstract class Writable{

    Long id;

    public abstract Csv toCSV();

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
