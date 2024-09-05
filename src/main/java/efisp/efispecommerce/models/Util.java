package efisp.efispecommerce.models;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public enum Util {

    RESOURCES_PATH_FOR_TEST(new Object() {
        String evaluate() {
            try {
                return Paths.get(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().resolve("resources").resolve("database").toString();
            } catch (URISyntaxException e) {
                System.out.println(e.getMessage());
            }

            return "";
        }
    }.evaluate()),

    /**
     * Path to the resources folder
     */
    RESOURCES_PATH(new Object() {
        String evaluate() {
            try {
                return Paths.get(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().getParent().getParent().resolve("resources").resolve("database").toString();
            } catch (URISyntaxException e) {
                System.out.println(e.getMessage());
            }

            return "";
        }
    }.evaluate()),
    /**
     * Path to the images folder
     */
    IMAGES_PATH(new Object() {
        String evaluate() {
            try {
                return Paths.get(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI())
                        .getParent().getParent().getParent().getParent()
                        .resolve("resources").toString();
            } catch (URISyntaxException e) {
                System.out.println(e.getMessage());
            }

            return "";
        }
    }.evaluate()),

    /**
     * Path to the config file
     */
    CONFIG_FILE(new Object() {
        String evaluate() {
            try {
                return Paths.get(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI())
                        .getParent().getParent().getParent().getParent()
                        .resolve("src").toString();
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
