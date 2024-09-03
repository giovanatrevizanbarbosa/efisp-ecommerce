package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.csv.Csv;
import efisp.efispecommerce.models.dao.Writable;

import java.util.UUID;

public class User extends Writable {
    private final String name;
    //identifier
    private final String email;
    private final String password;
    private final String photo;

    public User(UUID id, String name, String email, String password, String photo) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }

    @Override
    public Csv toCSV() {
        return new Csv(new String[]{"id", "name", "email", "password, photo"}, new String[]{String.valueOf(getId()), name, email, password, photo});
    }
}