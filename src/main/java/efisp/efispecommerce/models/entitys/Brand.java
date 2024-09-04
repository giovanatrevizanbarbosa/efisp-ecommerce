package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.UUID;

public class Brand extends Writable {
    private final String name;

    public Brand(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Csv toCSV() {
        return new Csv(
            new String[]{"id", "name"},
                new String[]{getId().toString(), name}
        );
    }
}