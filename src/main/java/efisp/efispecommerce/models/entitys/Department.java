package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.UUID;

public class Department extends Writable {
    //identifier
    private final String name;
    private final String description;

    public Department(UUID id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Csv toCSV() {
        return new Csv(
            new String[]{"id", "name", "description"},
                new String[]{getId().toString(), name, description}
        );
    }
}