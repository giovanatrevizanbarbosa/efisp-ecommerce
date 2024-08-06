package efisp.efispecommerce.models.entitys;

public class Title {
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
}