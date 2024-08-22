package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;

public class User implements Writable {
    private final int id;
    private final String name;
    //identifier
    private final String email;
    private final String password;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String[] toCSV() {
        return new String[]{String.valueOf(id), name, email, password};
    }
}