package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;

public class Brand implements Writable {
    //identifier
    private final String name;

    public Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String[] toCSV() {
        return new String[]{ name };
    }
}