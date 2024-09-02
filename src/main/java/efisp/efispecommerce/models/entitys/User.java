package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.csv.Csv;
import efisp.efispecommerce.models.dao.Writable;

public class User extends Writable {
    private final String name;
    //identifier
    private final String email;
    private final String password;

    public User(Long id, String name, String email, String password) {
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
}