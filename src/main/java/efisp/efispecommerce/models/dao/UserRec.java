package efisp.efispecommerce.models.dao;

public record UserRec(long id, String name, String email, String password) implements Writable {

    @Override
    public String[] toCSV() {
        return new String[]{String.valueOf(id), name, email, password};
    }
}
