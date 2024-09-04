package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.UUID;

public class Title extends Writable {
    //identifier
    private final String name;
    private int permissionLevel;

    public Title(UUID id, String name, int permissionLevel) {
        super(id);
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