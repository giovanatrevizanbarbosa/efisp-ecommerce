package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;

public class Title implements Writable {
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
    public String[] toCSV() {
        return new String[]{ name, String.valueOf(permissionLevel) };
    }
}