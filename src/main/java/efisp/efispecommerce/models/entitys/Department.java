package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;

public class Department implements Writable {
    //identifier
    private final String name;
    private final String description;

    public Department(String name, String description) {
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
    public String[] toCSV() {
        return new String[]{ name, description };
    }
}