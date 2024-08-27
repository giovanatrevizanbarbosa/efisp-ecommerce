package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.repository.csv.Csv;

public class Title extends Writable {
    //identifier
    private final String name;
    private int permissionLevel;

    public Title(String name, int permissionLevel) {
        this.name = name;
        this.permissionLevel = permissionLevel;
    }

    public String getName() {
        return name;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        if (permissionLevel > 0 && permissionLevel < 10)
            this.permissionLevel = permissionLevel;
    }

    @Override
    public Csv toCSV() {
        return new Csv(new String[]{"id", "name", "permissionLevel"}, new String[]{getId().toString(), name, String.valueOf(permissionLevel)});
    }
}