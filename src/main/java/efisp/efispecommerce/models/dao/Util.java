package efisp.efispecommerce.models.dao;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public enum Util {

    RESOURCES_PATH(new Object() {
        String evaluate() {
            try {
                return Paths.get(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().resolve("resources").resolve("database").toString();
            } catch (URISyntaxException e) {
                System.out.println(e.getMessage());
            }

            return "";
        }
    }.evaluate());

    private final String resourcesPath;

    Util(String resourcesPath) { this.resourcesPath = resourcesPath; }

    public String value() { return resourcesPath; }
}
