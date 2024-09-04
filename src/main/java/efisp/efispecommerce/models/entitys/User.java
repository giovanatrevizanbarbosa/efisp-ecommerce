package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.csv.Csv;
import efisp.efispecommerce.models.dao.Writable;

import java.util.UUID;

public class User extends Writable {
    private final String name;
    //identifier
    private final String email;
    private final String password;

    public User(UUID id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
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
    public Csv toCSV() {
        return new Csv(new String[]{"id", "name", "email", "password"}, new String[]{String.valueOf(getId()), name, email, password});
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (!(obj instanceof User user)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}